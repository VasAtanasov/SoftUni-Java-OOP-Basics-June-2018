package L08InheritanceExercises.ex02Bookshop;

class GoldenEditionBook extends Book {


    GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price * 1.3);
    }
}
