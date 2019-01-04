package L08InheritanceExercises.ex02Bookshop;

class Book {
    private String title;
    private String author;
    private double price;

    Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthorName(author.split("\\s+"));
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthorName(String[] author) {
        if (author.length > 1 && Character.isDigit(author[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        if (author.length == 1) {
            this.author = author[0];
        } else {
            StringBuilder authorName = new StringBuilder();
            for (String name : author) {
                authorName.append(name).append(" ");
            }
            this.author = authorName.toString().trim();
        }
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }


    private String getTitle() {
        return title;
    }

    private String getAuthor() {
        return author;
    }

    private double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append(String.format("Price: %.1f",this.getPrice()))
                .append(System.lineSeparator());
        return sb.toString();
    }

}
