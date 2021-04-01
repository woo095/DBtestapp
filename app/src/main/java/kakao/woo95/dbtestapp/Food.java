package kakao.woo95.dbtestapp;

public class Food {
    private int _id;
    private String _foodName;

    public Food() {
    }

    public Food(int id, String foodName) {
        this._id = id;
        this._foodName = foodName;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_foodName() {
        return _foodName;
    }

    public void set_foodName(String _foodName) {
        this._foodName = _foodName;
    }

    @Override
    public String toString() {
        return "food{" +
                "_id=" + _id +
                ", _foodName='" + _foodName + '\'' +
                '}';
    }
}
