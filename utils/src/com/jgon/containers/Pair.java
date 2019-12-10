package com.jgon.containers;

public final class Pair<A, B> {
    private A _first;
    private B _second;

    private Pair() {}

    public Pair(A firstParam, B secondParam) {
        _first = firstParam;
        _second = secondParam;
    }

    public A getFirst() {
        return _first;
    }

    public B getSecond() {
        return _second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }

        Pair pair = (Pair) o;

        if (_first != null ? !_first.equals(pair._first) : pair._first != null) {
            return false;
        }
        return !(_second != null ? !_second.equals(pair._second) : pair._second != null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("first: ").append(_first == null ? "null" : _first.toString());
        sb.append("second: ").append(_second == null ? "null" : _second.toString());
        return sb.toString();
    }

    public static <A, B> Pair<A, B> of(A firstParam, B secondParam) {
        return new Pair<>(firstParam, secondParam);
    }
}


