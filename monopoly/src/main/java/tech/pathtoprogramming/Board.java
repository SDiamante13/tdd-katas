package tech.pathtoprogramming;

interface Board {
    Property propertyAt(int location);
}

class FakeBoard implements Board {

    @Override
    public Property propertyAt(int location) {
        return new Property("Baltic Avenue", 60);
    }
}
