package org.testinfected.molecule.simple;

import org.testinfected.molecule.Session;
import org.testinfected.molecule.util.Clock;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class SimpleSession implements Session {

    private final org.simpleframework.http.session.Session session;

    public SimpleSession(org.simpleframework.http.session.Session session) {
        this.session = session;
    }

    public String id() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object key) {
        return session.containsKey(key);
    }

    @SuppressWarnings("unchecked")
    public void put(Object key, Object value) {
        session.put(key, value);
    }

    public Object get(Object key) {
        return session.get(key);
    }

    public Set<?> keys() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Collection<?> values() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public long timeout() {
        throw new UnsupportedOperationException();
    }

    public void timeout(long inSeconds) {
        throw new UnsupportedOperationException();
    }

    public boolean expired(Clock clock) {
        throw new UnsupportedOperationException();
    }

    public void touch(Clock clock) {
        throw new UnsupportedOperationException();
    }

    public void invalidate() {
        throw new UnsupportedOperationException();
    }

    public boolean invalid() {
        return false;
    }

    public Date createdAt() {
        throw new UnsupportedOperationException();
    }

    public Date lastAccessedAt() {
        throw new UnsupportedOperationException();
    }
}
