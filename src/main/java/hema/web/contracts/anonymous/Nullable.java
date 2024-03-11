package hema.web.contracts.anonymous;

public interface Nullable {

    /**
     * Determines whether the current object is empty.
     *
     * @return boolean
     */
    boolean isNullable();

    class AnonymousNullable implements Nullable {

        @Override
        public boolean isNullable() {
            return true;
        }
    }
}
