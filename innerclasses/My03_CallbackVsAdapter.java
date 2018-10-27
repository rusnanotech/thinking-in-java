package biz.markov.thinking.innerclasses;

class My03_A_Object {
    private static long count = 0;
    private final long id = count++;
    boolean status = true;

    public String toString() {
        return getClass().getSimpleName() + " " + id + " " + status;
    }
}

abstract class My03_A_Processor {
    abstract Object f(Object aObject);

    public String toString() {
        return getClass().getSimpleName();
    }
}

class My03_AT_Processor extends My03_A_Processor {
    public My03_A_Object f(Object object) {
        ((My03_A_Object)object).status = true;
        return (My03_A_Object)object;
    }
}

class My03_AF_Processor extends My03_A_Processor {
    public My03_A_Object f(Object object) {
        ((My03_A_Object)object).status = false;
        return (My03_A_Object)object;
    }
}

class My03_B_Object {
    private static long count = 0;
    private final long id = count++;
    int status = 0;

    public String toString() {
        return getClass().getSimpleName() + " " + id + " " + status;
    }
}

class My03_B_Processor {
    My03_B_Object f(My03_B_Object bObject) {
        return bObject;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    private class Closure extends My03_A_Processor {
        Object f(Object object) {
            return My03_B_Processor.this.f((My03_B_Object) object);
        }

        public String toString() {
            return My03_B_Processor.this.getClass().getSimpleName();
        }
    }

    My03_A_Processor getA() {
        return new Closure();
    }
}

class My03_B0_Processor extends My03_B_Processor {
    My03_B_Object f(My03_B_Object bObject) {
        bObject.status = 0;
        return bObject;
    }
}

class My03_B1_Processor extends My03_B_Processor {
    My03_B_Object f(My03_B_Object bObject) {
        bObject.status = 1;
        return bObject;
    }
}

class My03_A_Apply {
    public static void process(My03_A_Processor processor, Object object) {
        System.out.println("Processor: " + processor);
        System.out.println("Input: " + object);
        System.out.println("Output: " + processor.f(object) + "\n");
    }
}

class My03_B_Adapter extends My03_A_Processor {
    My03_B_Adapter(My03_B_Processor bProcessor) {
        this.bProcessor = bProcessor;
    }

    private My03_B_Processor bProcessor;

    Object f(Object object) {
        return bProcessor.f((My03_B_Object)object);
    }

    public String toString() {
        return bProcessor.getClass().getSimpleName();
    }
}

public class My03_CallbackVsAdapter {
    static Object[] objects = {
            new My03_A_Object(),
            new My03_A_Object(),
            new My03_B_Object(),
            new My03_B_Object(),
    };

    static void testAdapter() {
        System.out.println("Using Adapter pattern:\n");
        My03_A_Processor[] processors = {
                new My03_AT_Processor(),
                new My03_AF_Processor(),
                new My03_B_Adapter(new My03_B0_Processor()),
                new My03_B_Adapter(new My03_B1_Processor()),
        };
        for (int i = 0; i < processors.length; i++)
            My03_A_Apply.process(processors[i], objects[i]);
    }

    static void testCallback() {
        System.out.println("Using closure objects:\n");
        My03_A_Processor[] processors = {
                new My03_AT_Processor(),
                new My03_AF_Processor(),
                new My03_B0_Processor().getA(),
                new My03_B1_Processor().getA(),
        };
        for (int i = 0; i < processors.length; i++)
            My03_A_Apply.process(processors[i], objects[i]);
    }
    public static void main(String[] args) {
        testAdapter();
        testCallback();
    }
}
