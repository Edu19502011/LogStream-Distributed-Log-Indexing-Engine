package com.logstream.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a posting list entry in the inverted index.
 * Contains document ID, term positions, and frequency.
 */
public class PostingList {
    private final String docId;
    private final List<Integer> positions;
    private final int frequency;

    public PostingList(String docId, List<Integer> positions) {
        this.docId = docId;
        this.positions = new ArrayList<>(positions);
        this.frequency = positions.size();
    }

    public String getDocId() {
        return docId;
    }

    public List<Integer> getPositions() {
        return new ArrayList<>(positions);
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostingList that = (PostingList) o;
        return frequency == that.frequency &&
               Objects.equals(docId, that.docId) &&
               Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId, positions, frequency);
    }

    @Override
    public String toString() {
        return "PostingList{" +
               "docId='" + docId + '\'' +
               ", positions=" + positions +
               ", frequency=" + frequency +
               '}';
    }
}
