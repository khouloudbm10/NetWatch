
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.time.Instant;
import java.util.Scanner;

public class NetWatch {

    private static final int TIMEOUT_MS = 3000;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("==================================");
            System.out.println("       NetWatch v1.0");
            System.out.println(" Network Monitoring & Diagnostics");
            System.out.println("==================================");

            System.out.print("Enter a hostname or IP address: ");
            String host = scanner.nextLine().trim();

            if (host.isEmpty()) {
                System.out.println("Error: Host cannot be empty.");
                return;
            }

            System.out.print("Enter one TCP port (e.g. 443): ");
            String portInput = scanner.nextLine().trim();

            int port;

            try {
                port = Integer.parseInt(portInput);
            } catch (NumberFormatException e) {
                System.out.println("Error: Port must be a number.");
                return;
            }

            if (port < 1 || port > 65535) {
                System.out.println("Error: Port must be between 1 and 65535.");
                return;
            }

            System.out.println("\n--- Diagnostic Results ---");
            System.out.println("Target: " + host);
            System.out.println("Port: " + port);
            System.out.println("Timestamp: " + Instant.now());

            checkReachability(host);
            checkTcpPort(host, port);

            System.out.println("\nDiagnostic finished.");

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void checkReachability(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);

            System.out.println("Resolved IP: " + address.getHostAddress());

            boolean reachable = address.isReachable(TIMEOUT_MS);

            if (reachable) {
                System.out.println("Host reachability: REACHABLE");
            } else {
                System.out.println(
                    "Host reachability: NO RESPONSE " +
                    "(ICMP/firewall restrictions may apply)"
                );
            }

        } catch (IOException e) {
            System.out.println("Host resolution/reachability error: "
                    + e.getMessage());
        }
    }

    private static void checkTcpPort(String host, int port) {
        long start = System.nanoTime();

        try (Socket socket = new Socket()) {

            socket.connect(
                new InetSocketAddress(host, port),
                TIMEOUT_MS
            );

            long elapsedMs =
                (System.nanoTime() - start) / 1_000_000;

            System.out.println("TCP port status: OPEN / ACCEPTING CONNECTIONS");
            System.out.println("Connection time: " + elapsedMs + " ms");

        } catch (IOException e) {
            long elapsedMs =
                (System.nanoTime() - start) / 1_000_000;

            System.out.println("TCP port status: CONNECTION FAILED");
            System.out.println("Attempt duration: " + elapsedMs + " ms");
            System.out.println(
                "The service may be closed, filtered, or unreachable."
            );
        }
    }
}
