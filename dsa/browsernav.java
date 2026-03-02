public class browsernav {
    // Page class - each node in our browser history
class Page {
    String url;
    String title;
    Page prev;  // Previous page
    Page next;  // Next page
    
    public Page(String url, String title) {
        this.url = url;
        this.title = title;
        this.prev = null;
        this.next = null;
    }
}

// Browser class - manages doubly linked list
class Browser {
    private Page head;      // First page (oldest)
    private Page tail;      // Last page (newest)
    private Page current;   // Current page
    private int size;
    
    public Browser() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }
    
    // Visit new page (add to end)
    public void visit(String url, String title) {
        Page newPage = new Page(url, title);
        
        if (head == null) {
            // First page ever
            head = newPage;
            tail = newPage;
            current = newPage;
        } else {
            // Add to end and update links
            tail.next = newPage;
            newPage.prev = tail;
            tail = newPage;
            
            // Any forward history after current is lost
            if (current != null && current.next != null) {
                current.next = null;
                tail = current;
            }
            current = newPage;
        }
        size++;
        System.out.println("🌐 Visiting: " + title + " (" + url + ")");
    }
    
    // Go back one page
    public void goBack() {
        if (current == null || current.prev == null) {
            System.out.println("⛔ No previous page");
            return;
        }
        
        current = current.prev;
        System.out.println("◀ Back to: " + current.title);
    }
    
    // Go forward one page
    public void goForward() {
        if (current == null || current.next == null) {
            System.out.println("⛔ No forward page");
            return;
        }
        
        current = current.next;
        System.out.println("▶ Forward to: " + current.title);
    }
    
    // Show current page
    public void showCurrent() {
        if (current == null) {
            System.out.println("🏠 No page open");
        } else {
            System.out.println("📍 CURRENT: " + current.title + " - " + current.url);
        }
    }
    
    // Show full history
    public void showHistory() {
        if (head == null) {
            System.out.println("📜 No browsing history");
            return;
        }
        
        System.out.println("\n═══════ BROWSING HISTORY ═══════");
        Page temp = head;
        int count = 1;
        while (temp != null) {
            String marker = (temp == current) ? " ← CURRENT" : "";
            System.out.println(count + ". " + temp.title + " (" + temp.url + ")" + marker);
            temp = temp.next;
            count++;
        }
        System.out.println("══════════════════════════════════");
        System.out.println("Total pages: " + size);
    }
    
    // Clear history
    public void clearHistory() {
        head = null;
        tail = null;
        current = null;
        size = 0;
        System.out.println("🧹 History cleared");
    }
    
    // Jump to specific page by index
    public void jumpToPage(int index) {
        if (index < 1 || index > size) {
            System.out.println("⛔ Invalid page number");
            return;
        }
        
        Page temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        
        current = temp;
        System.out.println("🎯 Jumped to: " + current.title);
    }
    
    // Delete a specific page from history
    public void deletePage(String url) {
        if (head == null) {
            System.out.println("📜 History empty");
            return;
        }
        
        Page temp = head;
        while (temp != null) {
            if (temp.url.equals(url)) {
                // Update links
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next; // Deleting head
                }
                
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev; // Deleting tail
                }
                
                // If deleting current page, move current
                if (temp == current) {
                    current = (temp.next != null) ? temp.next : temp.prev;
                }
                
                size--;
                System.out.println("🗑 Deleted: " + temp.title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ Page not found");
    }
    
    // Get current page URL
    public String getCurrentUrl() {
        return (current != null) ? current.url : null;
    }
}

// Main class to test the browser
public class BrowserNavigation {
    public static void main(String[] args) {
        Browser myBrowser = new Browser();
        
        // Visit some pages
        System.out.println("🔍 BROWSING SESSION STARTED\n");
        
        myBrowser.visit("google.com", "Google");
        myBrowser.visit("youtube.com", "YouTube");
        myBrowser.visit("github.com", "GitHub");
        myBrowser.visit("stackoverflow.com", "Stack Overflow");
        
        // Show history
        myBrowser.showHistory();
        
        // Navigate
        System.out.println("\n🔄 NAVIGATION:");
        myBrowser.showCurrent();
        
        myBrowser.goBack();      // To GitHub
        myBrowser.goBack();      // To YouTube
        myBrowser.showCurrent();
        
        myBrowser.goForward();   // To GitHub
        myBrowser.showCurrent();
        
        // Visit new page (clears forward history)
        System.out.println("\n🆕 NEW PAGE:");
        myBrowser.visit("reddit.com", "Reddit");
        
        // Show updated history
        myBrowser.showHistory();
        
        // Jump to specific page
        System.out.println("\n🎯 JUMP TO PAGE:");
        myBrowser.jumpToPage(2);
        
        // Delete a page
        System.out.println("\n🗑 DELETE PAGE:");
        myBrowser.deletePage("youtube.com");
        
        // Final history
        myBrowser.showHistory();
        
        // Clear all
        System.out.println("\n🧹 CLEAR:");
        myBrowser.clearHistory();
        myBrowser.showHistory();
    }
}
}
