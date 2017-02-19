package MediaLibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryWithGenerics<E> {
    private List media = new ArrayList<E>();
    public void addMedia(E x) {
        media.add(x);
    }

    public void getMedia() {

        for (int i = 0; i < media.size(); i++) {
            System.out.println(media.get(i));
        }
    }
}
