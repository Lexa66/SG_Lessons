package MediaLibrary;


public class Main {
    public static void main(String[] args) {
        LibraryWithGenerics<Book> books = new LibraryWithGenerics<>();

        Book book = new Book();
        books.addMedia(book);
        books.getMedia();

        LibraryWithoutGenerics media = new LibraryWithoutGenerics();
        Book book1 = new Book();
        Video video = new Video();
        media.addMedia(book1);
        media.addMedia(video);
    }
}
