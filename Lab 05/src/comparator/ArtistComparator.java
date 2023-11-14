package comparator;

public class ArtistComparator{

    public ArtistComparator() {
    }

    public static int compareTo(Song song1, Song song2) {
        return song1.getArtist().compareToIgnoreCase(song2.getArtist());
    }
}
