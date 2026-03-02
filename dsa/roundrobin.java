public class roundrobin {
   class Process {
    int id;
    int burstTime;
    int remainingTime;
    Process next;
    
    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

public class SimpleRoundRobin {
    private Process head = null;
    private Process tail = null;
    private Process current = null;
    private int quantum;
    
    public SimpleRoundRobin(int quantum) {
        this.quantum = quantum;
    }
    
    // Add process
    public void addProcess(int id, int burstTime) {
        Process p = new Process(id, burstTime);
        
        if (head == null) {
            head = p;
            tail = p;
            p.next = head;  // Points to itself
            current = head;
        } else {
            tail.next = p;
            tail = p;
            tail.next = head;  // Circular
        }
        System.out.println("Added P" + id + " (Burst: " + burstTime + ")");
    }
    
    // Execute one round
    public void execute() {
        if (head == null) {
            System.out.println("No processes");
            return;
        }
        
        System.out.println("\nExecuting P" + current.id + " (Remaining: " + current.remainingTime + ")");
        
        // Run for quantum or until finish
        int runTime = Math.min(quantum, current.remainingTime);
        current.remainingTime -= runTime;
        System.out.println("Ran for " + runTime + ", Remaining: " + current.remainingTime);
        
        // Check if process finished
        if (current.remainingTime == 0) {
            System.out.println("P" + current.id + " COMPLETED!");
            
            // Remove process
            if (head == head.next) {  // Only one process
                head = null;
                tail = null;
                current = null;
                return;
            } else {
                // Find previous node
                Process temp = head;
                while (temp.next != current) {
                    temp = temp.next;
                }
                temp.next = current.next;
                if (current == head) head = current.next;
                if (current == tail) tail = temp;
                current = current.next;
            }
        } else {
            // Move to next
            current = current.next;
        }
        
        // Show queue
        showQueue();
    }
    
    // Show current queue
    public void showQueue() {
        if (head == null) {
            System.out.println("Queue: Empty");
            return;
        }
        
        System.out.print("Queue: ");
        Process temp = head;
        do {
            if (temp == current) System.out.print("👉");
            System.out.print("P" + temp.id + "(" + temp.remainingTime + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    
    // Run all processes to completion
    public void runAll() {
        System.out.println("\n=== ROUND ROBIN (Quantum=" + quantum + ") ===");
        showQueue();
        
        while (head != null) {
            execute();
        }
        System.out.println("\n✅ All processes completed!");
    }
    
    public static void main(String[] args) {
        SimpleRoundRobin rr = new SimpleRoundRobin(4);
        
        // Add processes
        rr.addProcess(1, 10);
        rr.addProcess(2, 6);
        rr.addProcess(3, 8);
        rr.addProcess(4, 4);
        
        // Run
        rr.runAll();
    }
} 
}
