package com.logstream.model;

import java.util.Objects;

/**
 * Represents a token extracted from text during tokenization.
 */
public class Token {
    private final String term;
    private final int position;
    private final int offset;

    public Token(String term, int position, int offset) {
        this.term = term;
        this.position = position;
        this.offset = offset;
    }

    public String getTerm() {
        return term;
    }

    public int getPosition() {
        return position;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return position == token.position &&
               offset == token.offset &&
               Objects.equals(term, token.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(term, position, offset);
    }

    @Override
    public String toString() {
        return "Token{" +
               "term='" + term + '\'' +
               ", position=" + position +
               ", offset=" + offset +
               '}';
    }
}
