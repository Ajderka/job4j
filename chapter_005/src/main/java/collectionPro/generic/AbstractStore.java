package collectionPro.generic;


public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> store = new SimpleArray<>(10);

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int count = 0;
        boolean result = false;
        for (T element : store) {
            if (element.getId().equals(id)) {
                store.set(count, model);
                result = true;
            }
            count++;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int count = 0;
        boolean result = false;
        for (T element : store) {
            if (element.getId().equals(id)) {
                store.remove(count);
                result = true;
            }
            count++;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T element : store) {
            if (element.getId().equals(id)) {
                result = element;
            }
        }
        return result;
    }
}
