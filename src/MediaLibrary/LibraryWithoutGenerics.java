package MediaLibrary;


import java.util.ArrayList;
import java.util.List;

public class LibraryWithoutGenerics {
    private List media = new ArrayList();

    public void addMedia(Media x) {
        media.add(x);
    }

    public void getMedia() {
        for (int i = 0; i < media.size(); i++) {
            System.out.println(media.get(i));
        }
    }
}

