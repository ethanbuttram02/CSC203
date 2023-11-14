package comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
           new Song("Avett Brothers", "Talk on Indolence", 2006),
           new Song("City and Colour", "Sleeping Sickness", 2007),
           new Song("Decemberists", "The Mariner's Revenge Song", 2005),
           new Song("Foo Fighters", "Baker Street", 1997),
           new Song("Gerry Rafferty", "Baker Street", 1998),
           new Song("Gerry Rafferty", "Baker Street", 1978),
           new Song("Queen", "Bohemian Rhapsody", 1975),
           new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
      );

      Collections.sort(songList, (Song s1, Song s2) -> ArtistComparator.compareTo(s1, s2));

      assertEquals(songList, expectedList);
   }

   @Test
   public void testLambdaTitleComparator()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
              new Song("Gerry Rafferty", "Baker Street", 1998),
              new Song("Foo Fighters", "Baker Street", 1997),
              new Song("Gerry Rafferty", "Baker Street", 1978),
              new Song("Queen", "Bohemian Rhapsody", 1975),
              new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
              new Song("City and Colour", "Sleeping Sickness", 2007),
              new Song("Avett Brothers", "Talk on Indolence", 2006),
              new Song("Decemberists", "The Mariner's Revenge Song", 2005)
      );

      Collections.sort(songList, (Song s1, Song s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle()));

      assertEquals(songList, expectedList);
   }

   @Test
   public void testYearExtractorComparator()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
              new Song("Queen", "Bohemian Rhapsody", 1975),
              new Song("Gerry Rafferty", "Baker Street", 1978),
              new Song("Foo Fighters", "Baker Street", 1997),
              new Song("Gerry Rafferty", "Baker Street", 1998),
              new Song("Decemberists", "The Mariner's Revenge Song", 2005),
              new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
              new Song("Avett Brothers", "Talk on Indolence", 2006),
              new Song("City and Colour", "Sleeping Sickness", 2007)
      );

      songList.sort(Comparator.comparing(Song::getYear));

      assertEquals(songList, expectedList);
   }

   @Test
   public void testComposedComparator()
   {
      Song song1 = new Song("Foo Fighters", "Baker Street", 1997);
      Song song2 = new Song("Gerry Rafferty", "Baker Street", 1998);

      Comparator<Song> artistCompare = new Comparator<Song>() {
         @Override
         public int compare(Song o1, Song o2) {
            return o1.getArtist().compareToIgnoreCase(o2.getArtist());
         }
      };
      Comparator<Song> yearCompare = Comparator.comparing(Song::getYear, (s1, s2) -> s1.compareTo(s2));
      ComposedComparator compCompare = new ComposedComparator(artistCompare, yearCompare);
      int result = compCompare.compare(song1, song2);

      assertTrue(result < 0);

      compCompare = new ComposedComparator(yearCompare, artistCompare);
      result = compCompare.compare(song1, song2);

      assertTrue(result < 0);
   }

   @Test
   public void testThenComparing()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
              new Song("Foo Fighters", "Baker Street", 1997),
              new Song("Gerry Rafferty", "Baker Street", 1998),
              new Song("Gerry Rafferty", "Baker Street", 1978),
              new Song("Queen", "Bohemian Rhapsody", 1975),
              new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
              new Song("City and Colour", "Sleeping Sickness", 2007),
              new Song("Avett Brothers", "Talk on Indolence", 2006),
              new Song("Decemberists", "The Mariner's Revenge Song", 2005)
      );

      Comparator<Song> thenCompare = new Comparator<Song>() {
         @Override
         public int compare(Song o1, Song o2) {
            return o1.getTitle().compareToIgnoreCase(o2.getTitle());
         }
      };
      songList.sort(Comparator.comparing(Song::getTitle).thenComparing(Song::getArtist));
      assertEquals(songList, expectedList);
   }

   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      songList.sort(Comparator.comparing(Song::getArtist).thenComparing(Song::getYear));

      assertEquals(songList, expectedList);
   }
}
