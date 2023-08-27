public class BeanTest {
    public static void main(String[] args) {
        Album album1 = new Album();
        Album album2= new Album();
        Album album3 = new Album();
        Quote quote1 = new Quote();
        Quote quote2 = new Quote();
        Quote quote3 = new Quote();
        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();
        Quote[] quoteArray = {quote1, quote2, quote3};
        for (Quote quote : quoteArray) {
            System.out.println(quote.getAuthor() + " " + quote.getContent());
        }
    }
}
