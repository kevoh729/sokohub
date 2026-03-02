public class playlist {
    // Song class - each node in our playlist
class Song {
    String title;
    String artist;
    Song next;  // Pointer to next song
    
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
    }
}

// Playlist class - manages the linked list
class Playlist {
    private Song head;  // First song
    private Song current;  // Currently playing
    private int size;
    
    public Playlist() {
        head = null;
        current = null;
        size = 0;
    }
    
    // Add song to end of playlist
    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);
        
        if (head == null) {
            head = newSong;
            current = head;
        } else {
            Song temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newSong;
        }
        size++;
        System.out.println("✓ Added: " + title + " - " + artist);
    }
    
    // Add song at specific position
    public void addSongAtPosition(String title, String artist, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("✗ Invalid position!");
            return;
        }
        
        Song newSong = new Song(title, artist);
        
        if (position == 1) {
            newSong.next = head;
            head = newSong;
            if (current == null) current = head;
        } else {
            Song temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newSong.next = temp.next;
            temp.next = newSong;
        }
        size++;
        System.out.println("✓ Added at position " + position + ": " + title);
    }
    
    // Remove song by title
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("✗ Playlist is empty!");
            return;
        }
        
        // If head needs to be removed
        if (head.title.equals(title)) {
            head = head.next;
            if (current == head) current = head;
            size--;
            System.out.println("✓ Removed: " + title);
            return;
        }
        
        // Search for song to remove
        Song temp = head;
        while (temp.next != null && !temp.next.title.equals(title)) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("✗ Song not found: " + title);
        } else {
            temp.next = temp.next.next;
            size--;
            System.out.println("✓ Removed: " + title);
        }
    }
    
    // Play current song
    public void playCurrent() {
        if (current == null) {
            System.out.println("⏸ No song playing");
        } else {
            System.out.println("▶ Playing: " + current.title + " - " + current.artist);
        }
    }
    
    // Play next song
    public void playNext() {
        if (current == null || current.next == null) {
            System.out.println("⏹ End of playlist");
        } else {
            current = current.next;
            playCurrent();
        }
    }
    
    // Play previous song
    public void playPrevious() {
        if (current == null || current == head) {
            System.out.println("⏹ Already at first song");
        } else {
            Song temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            current = temp;
            playCurrent();
        }
    }
    
    // Display all songs
    public void showPlaylist() {
        if (head == null) {
            System.out.println("📝 Playlist is empty");
            return;
        }
        
        System.out.println("\n═══════ YOUR PLAYLIST ═══════");
        Song temp = head;
        int position = 1;
        while (temp != null) {
            String playing = (temp == current) ? " ▶" : "";
            System.out.println(position + ". " + temp.title + " - " + temp.artist + playing);
            temp = temp.next;
            position++;
        }
        System.out.println("═══════════════════════════════");
        System.out.println("Total songs: " + size);
    }
    
    // Get playlist size
    public int getSize() {
        return size;
    }
}

// Main class to test the playlist
public class MusicPlayer {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        
        // Adding songs
        myPlaylist.addSong("Bohemian Rhapsody", "Queen");
        myPlaylist.addSong("Shape of You", "Ed Sheeran");
        myPlaylist.addSong("Blinding Lights", "The Weeknd");
        
        // Show playlist
        myPlaylist.showPlaylist();
        
        // Play controls
        System.out.println("\n🔊 PLAYBACK CONTROLS:");
        myPlaylist.playCurrent();      // First song
        myPlaylist.playNext();         // Second song
        myPlaylist.playNext();         // Third song
        myPlaylist.playPrevious();     // Back to second
        
        // Add at position
        myPlaylist.addSongAtPosition("Hotel California", "Eagles", 2);
        
        // Remove a song
        myPlaylist.removeSong("Shape of You");
        
        // Final playlist
        myPlaylist.showPlaylist();
    }
}
}
