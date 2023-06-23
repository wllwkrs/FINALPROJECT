import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArsyCell {
//Mendefinisikan kelas ArsyCell
    public static void main(String[] args) {
    //Mendefinisikan method
        Scanner scanner = new Scanner(System.in);
        String[] providers = {"Telkomsel", "Indosat", "3"};
        int[] pulsaPrices = {5000, 10000, 15000, 20000};
        String[] tokenAmounts = {"20000", "50000"};
        int[] tokenPrices = {20000, 50000};

        int antrian = 1; //Mendeklarasikan dan menginisialisasi variabel antrian dengan nilai 1.

        Queue<Integer> antrianQueue = new LinkedList<>();
        //Membuat objek antrianQueue sebagai implementasi kelas LinkedList dari antarmuka Queue dengan tipe elemen Integer.
        Stack<Integer> antrianStack = new Stack<>();

        while (true) {
        //perulangan
            System.out.println();
            System.out.println("Selamat datang di Arsy Cell!");
            System.out.println("Silakan pilih menu:");
            System.out.println("1. Beli Pulsa");
            System.out.println("2. Beli Listrik PLN");
            System.out.println("3. Sedang dalam antrian ke berapa");
            System.out.println("4. Keluar");
            System.out.println("Menu yang dipilih:");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (menuChoice) {
                case 1:
                    System.out.println();
                    System.out.println("Silakan pilih provider:");
                    for (int i = 0; i < providers.length; i++) {
                        System.out.println((i + 1) + ". " + providers[i]);
                    }
                    System.out.println("Provider yang dipilih:");

                    int providerChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    if (providerChoice < 1 || providerChoice > providers.length) {
                        System.out.println("Pilihan tidak valid.");
                        break;
                    }

                    System.out.println("Masukkan nomor HP:");
                    String phoneNumber = scanner.nextLine();

                    if (phoneNumber.length() < 11 || phoneNumber.length() > 13) {
                        System.out.println("Nomor HP tidak valid. Mohon periksa kembali.");
                        break;
                    }

                    System.out.println("Silakan pilih jumlah pulsa:");

                    for (int i = 0; i < pulsaPrices.length; i++) {
                        System.out.println((i + 1) + ". " + pulsaPrices[i] + " - Harga: " + (pulsaPrices[i] + 2000));
                    }

                    System.out.println("Jumlah Pulsa yang dipilih:");
                    int pulsaChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    if (pulsaChoice < 1 || pulsaChoice > pulsaPrices.length) {
                        System.out.println("Pilihan tidak valid.");
                        break;
                    }

                    System.out.println();
                    System.out.println("Konfirmasi Pulsa:");
                    System.out.println("Provider: " + providers[providerChoice - 1]);
                    System.out.println("Nomor HP: " + phoneNumber);
                    System.out.println("Jumlah Pulsa: " + pulsaPrices[pulsaChoice - 1]);
                    System.out.println("Harga: " + (pulsaPrices[pulsaChoice - 1] + 2000));
                    System.out.println("Apakah Anda ingin melanjutkan? (Pesan / Batal)");
                    String confirmation = scanner.nextLine();

                    if (confirmation.equalsIgnoreCase("Pesan")) {
                        System.out.println("Silakan pilih metode pembayaran:");
                        System.out.println("1. ShopeePay");
                        System.out.println("2. Transfer Bank");
                        System.out.println("3. DANA");
                        System.out.println("Metode pembayaran yang dipilih:");

                        int paymentMethodChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        switch (paymentMethodChoice) {
                            case 1:
                                System.out.println("Anda telah memilih ShopeePay sebagai metode pembayaran.");
                                break;
                            case 2:
                                System.out.println("Anda telah memilih Transfer Bank sebagai metode pembayaran.");
                                break;
                            case 3:
                                System.out.println("Anda telah memilih DANA sebagai metode pembayaran.");
                                break;
                            default:
                                System.out.println("Pilihan metode pembayaran tidak valid.");
                                break;
                        }

                        if (paymentMethodChoice >= 1 && paymentMethodChoice <= 3) {
                            // Tampilkan pesan terima kasih dan nomor antrian
                            System.out.println("Terima kasih telah berbelanja di Arsy Cell.");
                            System.out.println("Pesanan Anda sedang diproses.");
                            System.out.println("Nomor antrian Anda: " + antrian);
                            antrianQueue.offer(antrian);
                            antrianStack.push(antrian);
                            antrian++;
                        }

                    } else if (confirmation.equalsIgnoreCase("Batal")) {
                        System.out.println("Pesanan Anda telah dibatalkan.");
                    } else {
                        System.out.println("Pilihan tidak valid. Pesanan Anda dibatalkan.");
                    }

                    break;

                case 2:
                    System.out.println();
                    System.out.println("Silakan pilih jenis listrik PLN:");
                    System.out.println("1. Token Listrik");
                    System.out.println("2. Tagihan Listrik");
                    System.out.println("Jenis listrik PLN yang dipilih:");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    if (paymentChoice == 1) {
                        System.out.println();
                        System.out.println("Masukkan nomor meter/ID pelanggan:");
                        String meterNumber = scanner.nextLine();

                        if (meterNumber.length() < 11 || meterNumber.length() > 12) {
                            System.out.println("Nomor meter/ID pelanggan tidak valid. Mohon periksa kembali.");
                            break;
                        }

                        System.out.println();
                        System.out.println("Silakan pilih jumlah top-up token listrik:");
                        for (int i = 0; i < tokenAmounts.length; i++) {
                            System.out.println((i + 1) + ". " + tokenAmounts[i] + " - Harga: " + (tokenPrices[i] + 2000));
                        }

                        System.out.println("Jumlah yang dipilih :");
                        int tokenChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        System.out.println("Konfirmasi Token Listrik:");
                        System.out.println("Nomor Meter/ID Pelanggan: " + meterNumber);
                        System.out.println("Jumlah Top-up: " + tokenAmounts[tokenChoice - 1]);
                        System.out.println("Harga: " + (tokenPrices[tokenChoice - 1] + 2000));
                        System.out.println("Apakah Anda ingin melanjutkan? (Pesan / Batal)");
                        confirmation = scanner.nextLine();

                        if (confirmation.equalsIgnoreCase("Pesan")) {
                            System.out.println();
                            System.out.println("Silakan pilih metode pembayaran:");
                            System.out.println("1. ShopeePay");
                            System.out.println("2. Transfer Bank");
                            System.out.println("3. DANA");
                            System.out.println("Metode pembayaran yang dipilih:");

                            int paymentMethodChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character

                            switch (paymentMethodChoice) {
                                case 1:
                                    System.out.println("Anda telah memilih ShopeePay sebagai metode pembayaran.");
                                    break;
                                case 2:
                                    System.out.println("Anda telah memilih Transfer Bank sebagai metode pembayaran.");
                                    break;
                                case 3:
                                    System.out.println("Anda telah memilih DANA sebagai metode pembayaran.");
                                    break;
                                default:
                                    System.out.println("Pilihan metode pembayaran tidak valid.");
                                    break;
                            }

                            if (paymentMethodChoice >= 1 && paymentMethodChoice <= 3) {
                                // Tampilkan pesan terima kasih dan nomor antrian
                                System.out.println("Terima kasih telah berbelanja di Arsy Cell.");
                                System.out.println("Pesanan Anda sedang diproses.");
                                System.out.println("Nomor antrian Anda: " + antrian);
                                antrianQueue.offer(antrian);
                                antrianStack.push(antrian);
                                antrian++;
                            }

                        } else if (confirmation.equalsIgnoreCase("Batal")) {
                            System.out.println("Pesanan Anda telah dibatalkan.");
                        } else {
                            System.out.println("Pilihan tidak valid. Pesanan Anda dibatalkan.");
                        }
                    } else if (paymentChoice == 2) {
                        System.out.println("Masukkan ID pelanggan / nomor meter:");
                        String idPelanggan = scanner.nextLine();

                        // Lakukan pengecekan tagihan

                        System.out.println("Tagihan dengan ID pelanggan / nomor meter " + idPelanggan + " adalah xxx rupiah.");

                        System.out.println("Apakah Anda ingin melanjutkan? (Pesan / Batal)");
                        confirmation = scanner.nextLine();

                        if (confirmation.equalsIgnoreCase("Pesan")) {
                            System.out.println();
                            System.out.println("Silakan pilih metode pembayaran:");
                            System.out.println("1. ShopeePay");
                            System.out.println("2. Transfer Bank");
                            System.out.println("3. DANA");
                            System.out.println("Metode pembayaran yang dipilih:");

                            int paymentMethodChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character

                            switch (paymentMethodChoice) {
                                case 1:
                                    System.out.println("Anda telah memilih ShopeePay sebagai metode pembayaran.");
                                    break;
                                case 2:
                                    System.out.println("Anda telah memilih Transfer Bank sebagai metode pembayaran.");
                                    break;
                                case 3:
                                    System.out.println("Anda telah memilih DANA sebagai metode pembayaran.");
                                    break;
                                default:
                                    System.out.println("Pilihan metode pembayaran tidak valid.");
                                    break;
                            }

                            if (paymentMethodChoice >= 1 && paymentMethodChoice <= 3) {
                                // Tampilkan pesan terima kasih dan nomor antrian
                                System.out.println("Terima kasih telah berbelanja di Arsy Cell.");
                                System.out.println("Pesanan Anda sedang diproses.");
                                System.out.println("Nomor antrian Anda: " + antrian);
                                antrianQueue.offer(antrian);
                                antrianStack.push(antrian);
                                antrian++;
                            }

                        } else if (confirmation.equalsIgnoreCase("Batal")) {
                            System.out.println("Pesanan Anda telah dibatalkan.");
                        } else {
                            System.out.println("Pilihan tidak valid. Pesanan Anda dibatalkan.");
                        }
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }

                    break;

                case 3:
                    if (!antrianQueue.isEmpty()) {
                        System.out.println("Anda sedang dalam antrian ke-" + antrianQueue.peek());
                        System.out.println("Antrian saat ini:");
                        System.out.println(antrianQueue);
                    } else {
                        System.out.println("Anda tidak sedang dalam antrian.");
                    }
                    
                    System.out.println("Isi stack saat ini:");
                    System.out.println(antrianStack);
                    break;

                case 4:
                    System.out.println("Terima kasih atas kepercayaan Anda dalam menggunakan layanan Arsy Cell. Kami senang dapat melayani Anda.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
