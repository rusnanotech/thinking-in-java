package biz.markov.thinking.enumerated;

import net.mindview.util.Enums;

import java.util.EnumMap;
import java.util.Iterator;

import static biz.markov.thinking.enumerated.Mail2.*;
import static biz.markov.thinking.enumerated.Mail2.MailAttribute.ForwardAddress;
import static biz.markov.thinking.enumerated.Mail2.MailAttribute.GeneralDelivery;
import static biz.markov.thinking.enumerated.Mail2.MailAttribute.Readability;
import static biz.markov.thinking.enumerated.Mail2.MailAttribute.ReturnAddress;
import static biz.markov.thinking.enumerated.Mail2.MailAttribute.Scannability;
import static biz.markov.thinking.enumerated.Mail2.MailAttribute.Address;
import static net.mindview.util.Print.print;

class Mail2 {
    interface MailAttribute {
        // The NO's lower the probability of random selection:
        enum GeneralDelivery implements MailAttribute {YES, NO1, NO2, NO3, NO4, NO5}

        enum Scannability implements MailAttribute {UNSCANNABLE, YES1, YES2, YES3, YES4}

        enum Readability implements MailAttribute {ILLEGIBLE, YES1, YES2, YES3, YES4}

        enum Address implements MailAttribute {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

        enum ReturnAddress implements MailAttribute {MISSING, OK1, OK2, OK3, OK4, OK5}

        enum ForwardAddress implements MailAttribute {MISSING, OK1, OK2, OK3, OK4, OK5}
    }

    static long counter = 0;
    long id = counter++;

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    ForwardAddress forwardAddress;

    // Generate test Mail:
    public static Mail2 randomMail() {
        Mail2 m = new Mail2();

        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        m.forwardAddress = Enums.random(ForwardAddress.class);

        return m;
    }

    public static Iterable<Mail2> generator(final int count) {
        return new Iterable<Mail2>() {
            int n = count;

            public Iterator<Mail2> iterator() {
                return new Iterator<Mail2>() {
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    public Mail2 next() {
                        return randomMail();
                    }

                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress +
                ", Forward address: " + forwardAddress;
    }
}

public class Ex09_PostOffice {
    EnumMap<MailHandler, MailAttribute> handlerMap
            = new EnumMap<MailHandler, MailAttribute>(MailHandler.class);

    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(Mail2 m) {
                switch (m.generalDelivery) {
                    case YES:
                        print("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail2 m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail2 m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail2 m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        print("Returning " + m + " to sender");
                        return true;
                }
            }
        },
        FORWARD {
            boolean handle(Mail2 m) {
                switch (m.forwardAddress) {
                    case MISSING:
                        return false;
                    default:
                        print("Forwarding " + m + " normally");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail2 m);
    }

    static void handle(Mail2 m) {
        for (MailHandler handler : MailHandler.values())
            if (handler.handle(m))
                return;
        print(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail2 mail : generator(16)) {
            print(mail.details());
            handle(mail);
            print("*****");
        }
    }
}
