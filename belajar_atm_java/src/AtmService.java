import javax.swing.plaf.PanelUI;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AtmService {
    Scanner scan = new Scanner(System.in);
    HashMap<String, String> listKodeBank = new HashMap<>();
    AtmModel atmModel = new AtmModel();
    double saldo = 5000000;
    int pilihanBatal;

    public static void main(String[] args){
        AtmService atmService = new AtmService();
        atmService.loginPin();
    }

    public void loginPin() {
        int x = 0;
            System.out.println("|| ======================================== ||");
            System.out.println("||          SELAMAT DATANG DI ATM BCA       ||");
            System.out.println("|| ======================================== ||");
            System.out.println("||                                          ||");
            System.out.println("||             MASUKKAN PIN ANDA :          ||");
            System.out.println("||                                          ||");
            System.out.print("  PIN ANDA >>");

            String pin = scan.next();
            int cekPin2 = pin.length();
            if (cekPin2 == 6) {
                tampilanMenuUtamaAtm();
            } else {
                System.out.println("PIN YANG ANDA MASUKKAN SALAH");
                loginPin();
            }
    }
    public void tampilanMenuUtamaAtm(){
        System.out.println("|| ======================================== ||");
        System.out.println("||                BANK BCA                  ||");
        System.out.println("|| ======================================== ||");
        System.out.println("||  1 <= 100.000             500.000  => 5  ||");
        System.out.println("||  2 <= 200.000            1.000.000 => 6  ||");
        System.out.println("||  3 <= 300.000            1.250.000 => 7  ||");
        System.out.println("||  4 <= DAFTAR             TRANSFER  => 8  ||");
        System.out.println("||       KODE BANK          / LAINNYA       ||");
        System.out.println("");
        System.out.println("||      TEKAN '9' UNTUK CANCEL     ||");
        System.out.print("PILIH >>");
        int pilihMenu = scan.nextInt();

        switch (pilihMenu) {
            case 1 :
                tarik100();
                break;
            case 2:
                tarik200();
                break;
            case 3:
                tarik300();
                break;
            case 4:
                daftarKodeBank();
                break;
            case 5:
                tarik500();
                break;
            case 6:
                tarik1000();
                break;
            case 7:
                tarik1250();
                break;
            case 8:
                transferLainnya();
                break;
            case 9:
                keluar();
                break;
            default:
                System.out.println("PILIH MENU DENGAN BENAR");
        }
    }

    public void tarik100(){
        double sisaSaldo = saldo - 100000;
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||       ANDA SUDAH MELAKUKAN PEANARIKAN    ||");
        System.out.println("||                SEBESAR 100.000           ||");
        System.out.println("||      SISA SALDO ANDA : Rp" +sisaSaldo+  "||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void tarik200(){
        double sisaSaldo = saldo - 200000;
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||       ANDA SUDAH MELAKUKAN PEANARIKAN    ||");
        System.out.println("||              SEBESAR  200.000           ||");
        System.out.println("||      SISA SALDO ANDA : Rp" +sisaSaldo+  "||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void tarik300(){
        double sisaSaldo = saldo - 300000;
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||       ANDA SUDAH MELAKUKAN PEANARIKAN    ||");
        System.out.println("||               SEBESAR  300.000           ||");
        System.out.println("||      SISA SALDO ANDA : Rp" +sisaSaldo+  "||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void daftarKodeBank(){
        System.out.println("KODE BANK");
        listKodeBank.put("002", "BRI");
        listKodeBank.put("008", "MANDIRI");
        listKodeBank.put("009", "BNI");
        listKodeBank.put("200", "BIN");
        listKodeBank.put("014", "BCA");
        listKodeBank.put("016", "BII");
        listKodeBank.put("118", "BANK BJB");
        listKodeBank.put("451", "BSM");
        listKodeBank.put("052", "RBS");
        listKodeBank.put("441", "BUKOPIN");
        listKodeBank.put("831", "CITIBANK");
        listKodeBank.put("111", "DKI");
        listKodeBank.put("426", "MEGA");
        listKodeBank.put("822", "CIMB NIAGA");
        listKodeBank.put("422", "BRI SYARIAH");
        listKodeBank.put("011", "DANAMON");
        listKodeBank.put("113", "JATENG");
        listKodeBank.put("114", "JATIM");
        listKodeBank.put("147", "MUAMALAT");
        listKodeBank.put("013", "PERMATA");

        for(Map.Entry map : listKodeBank.entrySet()) {
            System.out.println("Kode : " +map.getKey()+ "    Nama Bank : " +map.getValue());
        }
        System.out.println("              TRANSFER ANTAR  => 1 ");
        System.out.println("              BANK LAIN            ");
        System.out.println("              CANCEL          => 2 ");
        System.out.println("TEKAN 0 CANCEL");
        int kembali = scan.nextInt();
        if (kembali == 0) {
            tampilanMenuUtamaAtm();
        } else if (kembali == 1) {
            transferAntarBank();
        } else if (kembali == 2) {
            tampilanMenuUtamaAtm();
        } else {
            System.out.println(" MASUKKAN PILIHAN DENGAN BENAR ");
        }
    }

    public void tarik500(){
        double sisaSaldo = saldo - 500000;
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||       ANDA SUDAH MELAKUKAN PEANARIKAN    ||");
        System.out.println("||               SEBESAR  500.000           ||");
        System.out.println("||      SISA SALDO ANDA : Rp" +sisaSaldo+  "||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void tarik1000(){
        double sisaSaldo = saldo - 1000000;
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||       ANDA SUDAH MELAKUKAN PEANARIKAN    ||");
        System.out.println("||              SEBESAR 1.000.000           ||");
        System.out.println("||      SISA SALDO ANDA : Rp" +sisaSaldo+  "||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void tarik1250(){
        double sisaSaldo = saldo - 1250000;
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||       ANDA SUDAH MELAKUKAN PEANARIKAN    ||");
        System.out.println("||              SEBESAR 1.250.000           ||");
        System.out.println("||      SISA SALDO ANDA : Rp" +sisaSaldo+  "||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void transferLainnya(){
        System.out.println("|| ======================================== ||");
        System.out.println("||                  BANK BCA                ||");
        System.out.println("|| ======================================== ||");
        System.out.println("||   1 <= PENARIKAN        INFO SALDO => 4  ||");
        System.out.println("||   2 <= TRANSFER         UBAH PIN   => 5  ||");
        System.out.println("||   3 <= BELI/BAYAR       KELUAR     => 6  ||");
        System.out.println("");
        System.out.println("||           TEKAN '9' UNTUK CANCEL         ||");
        System.out.print("PILIH >>");
        int pilihMenu = scan.nextInt();

        switch (pilihMenu) {
            case 1 :
                penarikanTunai();
                break;
            case 2:
                transfer();
                break;
            case 3:
                pembelian();
                break;
            case 4:
                infoSaldo();
                break;
            case 5:
                ubahPin();
                break;
            case 6:
                keluar();
                break;
            default:
                System.out.println("PILIH MENU TRANSFER DENGAN BENAR");
        }
    }

    public void penarikanTunai(){
        System.out.println("|| ======================================== ||");
        System.out.println("||               MASUKKAN JUMLAH            ||");
        System.out.println("||               PENARIKAN DALAM            ||");
        System.out.println("||              KELIPATAN RP 50000          ||");
        System.out.println("||          MAKSIMUM 1 KALI PENARIKAN       ||");
        System.out.println("||                   1250000                ||");
        System.out.println("||                                          ||");
        System.out.print("        Rp :  ");
        int penarikan = scan.nextInt();

        if(penarikan >= 50000 && penarikan <= 1250000){
            if (penarikan <= saldo) {
                double sisaSaldo = saldo - penarikan;
                System.out.println("|| ======================================== ||");
                System.out.println("||                 BANK BCA                 ||");
                System.out.println("|| ======================================== ||");
                System.out.println("||      ANDA SUDAH MELAKUKAN PEANARIKAN     ||");
                System.out.println("||           SEBESAR" + penarikan   +"      ||");
                System.out.println("||      SISA SALDO ANDA : Rp"+sisaSaldo+   "||");
                System.out.println("||                                          ||");
                System.out.println("|| ======================================== ||");
                cetakResi();
            } else {
                System.out.println("JUMLAH PENARIKAN LEBIH BESAR DARI SALDO");
                penarikanTunai();
            }
        } else {
            penarikanTunai();
        }
    }

    public void transfer(){
//        String noRekening = null;
        int jumlahTransfer = 0, kodeBank, pilihanTransfer, noRekening = 0;
//        int cekRekening = noRekening.length();
        System.out.println("|| ======================================== ||");
        System.out.println("||                 BANK BCA                 ||");
        System.out.println("|| ======================================== ||");
        System.out.println("||         PILIH BANK TUJUAN TRANSFER       ||");
        System.out.println("||                           BANK BCA => 1  ||");
        System.out.println("||                          BANK LAIN => 2  ||");
        System.out.println("||             TEKAN 0 UNTUK BATAL          ||");
        System.out.print("PILIH >>");
        pilihanTransfer = scan.nextInt();
        if (pilihanTransfer == 1){
            System.out.println("MASUKKAN NO REKENING TUJUAN");
            System.out.println("No Rekening : ");
            noRekening = scan.nextInt();
            System.out.println("MASUKKAN JUMLAH TRANSFER");
            System.out.print("Rp. ");
            jumlahTransfer = scan.nextInt();
            if(jumlahTransfer < saldo && jumlahTransfer >= 50000 && jumlahTransfer <= 2000000){
                saldo = saldo - jumlahTransfer;
                System.out.println("|| ======================================== ||");
                System.out.println("||                 BANK BCA                 ||");
                System.out.println("|| ======================================== ||");
                System.out.println("||    No Rek Tujuan :   " +noRekening+    "||");
                System.out.println("||       a/n      :    Hamba Allah          ||");
                System.out.println("||    Jumlah Transfer :"+jumlahTransfer+   "||");
                System.out.println("");
                System.out.println("||     Apakah Anda Yakin untuk Transfer?    ||");
                System.out.println("||                                 YA  => 1 ||");
                System.out.println("||                              TIDAK  => 2 ||");
                System.out.println("|| ======================================== ||");
                int pilihan = scan.nextInt();
                if(pilihan == 1) {
                    System.out.println("|| ======================================== ||");
                    System.out.println("||                                          ||");
                    System.out.println("||              TRANSAKSI BERHASIL          ||");
                    System.out.println("||                                          ||");
                    System.out.println("|| ======================================== ||");
                    pilihanKeluar();
                } else if (pilihan == 2) {
                    System.out.println("|| ======================================== ||");
                    System.out.println("||                                          ||");
                    System.out.println("||             TRANSAKSI DIBATALKAN         ||");
                    System.out.println("||                                          ||");
                    System.out.println("|| ======================================== ||");
                    pilihanKeluar();
                }
            } else {
                System.out.println("MINIMUM TRANSFER Rp 50000 ");
                System.out.println("MAKSIMUM TRANSFER Rp 2000000");
                transfer();
            }

        } else if (pilihanTransfer == 2) {
            transferAntarBank();
        }
    }

    public void transferAntarBank(){
        int kodeBank, jumlahTransfer, noRekening = 0;
        System.out.println("|| ======================================== ||");
        System.out.println("||           TRANSFER ANTAR BANK            ||");
        System.out.println("||                                          ||");
        System.out.println("||                             Lanjut  => 1 ||");
        System.out.println("||                    Daftar Kode Bank => 2 ||");
        System.out.println("||                               Batal => 3 ||");
        System.out.print("PILIH >>");
        int pilihan = scan.nextInt();
        if (pilihan == 1){
            System.out.print(" Masukkan Kode Bank : ");
            kodeBank = scan.nextInt();
            System.out.println("|| ======================================== ||");
            System.out.println("        Kode Bank      :     "+kodeBank+"     ");
            System.out.println("||                                          ||");
            System.out.println("||                             Lanjut  => 1 ||");
            System.out.print("PILIH >>");
            int pilihTransferAntarBank = scan.nextInt();
            if(pilihTransferAntarBank == 1) {
                System.out.println("|| ======================================== ||");
                System.out.println("||          MASUKKAN JUMLAH TRANSFER        ||");
                System.out.println("||                                          ||");
                System.out.print("\t \n JUMLAH TRANSFER  :        ");
                jumlahTransfer = scan.nextInt();
//                    if (jumlahTransfer < saldo && jumlahTransfer > 50000 && jumlahTransfer < 2000000) {
                saldo = saldo - jumlahTransfer;
                System.out.println("|| ======================================== ||");
                System.out.println("||                 BANK BCA                 ||");
                System.out.println("|| ======================================== ||");
                System.out.println("|| No Rek Tujuan :" + kodeBank + "" + noRekening + "||");
                System.out.println("||       a/n      :    Hamba Allah          ||");
                System.out.println("||    Jumlah Transfer :" + jumlahTransfer + "||");
                System.out.println("");
                System.out.println("||     Apakah Anda Yakin untuk Transfer?    ||");
                System.out.println("||                                 YA  => 1 ||");
                System.out.println("||                              TIDAK  => 2 ||");
                System.out.println("|| ======================================== ||");
                int pilih = scan.nextInt();
                if (pilihan == 1) {
                    System.out.println("|| ======================================== ||");
                    System.out.println("||                                          ||");
                    System.out.println("||              TRANSAKSI BERHASIL          ||");
                    System.out.println("||                                          ||");
                    System.out.println("|| ======================================== ||");
                    cetakResi();
                } else if (pilih == 2) {
                    System.out.println("|| ======================================== ||");
                    System.out.println("||                                          ||");
                    System.out.println("||             TRANSAKSI DIBATALKAN         ||");
                    System.out.println("||                                          ||");
                    System.out.println("|| ======================================== ||");
                    pilihanKeluar();
                } else {
                    System.out.println("MASUKKAN PILIHAN DENGAN BENAR ! ");
                }
//                    } else {
//                        System.out.println("MINIMUM TRANSFER Rp 50000 ");
//                        System.out.println("MAKSIMUM TRANSFER Rp 2000000");
//                        transfer();
//                    }
            } else {
                System.out.println("Masukkan  Pilihan dengan benar !");
            }
        } else if ( pilihan == 2){
            daftarKodeBank();
        } else if ( pilihan == 3){
            pilihanKeluar();
        }
        else {
            System.out.println("Masukkan  Pilihan dengan benar !");
        }

    }

    public void pembelian(){
        System.out.println("|| ======================================== ||");
        System.out.println("||           PEMBAYARAN/PEMBELIAN           ||");
        System.out.println("|| ======================================== ||");
        System.out.println("||  1 <= LISTRIK/PLN         VOUCHER  => 2  ||");
        System.out.println("||                                          ||");
        System.out.println("");
        System.out.println("||            TEKAN '9' UNTUK CANCEL        ||");
        System.out.print("PILIH >>");
        int pilihPembelian = scan.nextInt();
        if(pilihPembelian == 1){
            bayarListrik();
        } else if (pilihPembelian == 2){
            beliVoucher();
        } else {
            System.out.println("MASUKKAN PILIHAN DENGAN BENAR");
        }

    }

    public void bayarListrik(){
        System.out.print("NO PLN ANDA : ");
        int noPln = scan.nextInt();
        System.out.println("   ========================================   ");
        System.out.println("                  NO PLN ANDA                 ");
        System.out.println("                   "+noPln+"                  ");
        System.out.println("                                  LANJUT  => 1");
        System.out.println("                                  BATAL   => 2");
        System.out.println("");
        System.out.print("PILIH >>");
        int pilih = scan.nextInt();
        if (pilih == 1){
            System.out.println("   ========================================   ");
            System.out.println("              KONFIRMASI PEMBAYARAN           ");
            System.out.println("   ========================================   ");
            System.out.println("     ID PELANGGAN  :  "+noPln);
            System.out.println("     NAMA          :  BANG JAGO");
            System.out.println("     TAGIHAN OUTS  :  RP.60.600");
            System.out.println("");
            System.out.println("                                  BAYAR   => 1");
            System.out.println("                                  BATAL   => 2");
            System.out.print("PILIH >>");
            int pilihan = scan.nextInt();
            if (pilihan == 1){
                persetujuanTransaksi();
            } else if (pilihan == 2){
                pembatalanTransaksi();
            } else {
                System.out.println("MASUKKAN PILIHAN DENGAN BENAR");
            }
        } else if ( pilih == 2){
            tampilanMenuUtamaAtm();
        } else{
            System.out.println("MASUKKAN PILIHAN DENGAN BENAR ");
        }
    }

    public void beliVoucher(){
        System.out.println(" ======================================== ");
        System.out.println("          SILAHKAN PILIH PROVIDER         ");
        System.out.println("");
        System.out.println("  1 <= TELKOMSEL            INDOSAT => 2  ");
        System.out.println("");
        System.out.print("PILIH >>");
        int pilih = scan.nextInt();
        if (pilih == 1 || pilih == 2){
            transaksiBeliVoucher();
        } else {
            System.out.println(" MASUKKAN PILIHAN DENGAN BENAR ");
        }
    }

    public void transaksiBeliVoucher(){
        System.out.println(" ======================================== ");
        System.out.println("              PEMBELIAN VOUCHER           ");
        System.out.println("");
        System.out.println("  1 <= 25.000               100.000 => 3  ");
        System.out.println("  2 <= 50.000               150.000 => 4  ");
        System.out.println("");
        System.out.print("PILIH >>");
        int pilih = scan.nextInt();
        if (pilih == 1) {
            System.out.print("NO HP ANDA : ");
            int noHp = scan.nextInt();
            System.out.println("   ========================================   ");
            System.out.println("              KONFIRMASI PEMBAYARAN           ");
            System.out.println("   ========================================   ");
            System.out.println("     NO HP         :  "+noHp);
            System.out.println("     NAMA          :  BANG JAGO");
            System.out.println("     VOUCHER       :  RP. 25.000");
            System.out.println("");
            System.out.println("                                  BAYAR   => 1");
            System.out.println("                                  BATAL   => 2");
            System.out.print("PILIH >>");
            int pilihKonfirmasi = scan.nextInt();
            if (pilihKonfirmasi == 1) {
                persetujuanTransaksi();
            } else if ( pilihKonfirmasi == 2) {
                pembatalanTransaksi();
            } else {
                System.out.println(" MASUKKAN PILIHAN DENGAN BENAR ");
            }
        } else if (pilih == 2) {
            System.out.print("NO HP ANDA : ");
            int noHp = scan.nextInt();
            System.out.println("   ========================================   ");
            System.out.println("              KONFIRMASI PEMBAYARAN           ");
            System.out.println("   ========================================   ");
            System.out.println("     NO HP         :  "+noHp);
            System.out.println("     NAMA          :  BANG JAGO");
            System.out.println("     VOUCHER       :  RP. 50.000");
            System.out.println("");
            System.out.println("                                  BAYAR   => 1");
            System.out.println("                                  BATAL   => 2");
            System.out.print("PILIH >>");
            int pilihKonfirmasi = scan.nextInt();
            if (pilihKonfirmasi == 1) {
                persetujuanTransaksi();
            } else if ( pilihKonfirmasi == 2) {
                pembatalanTransaksi();
            } else {
                System.out.println(" MASUKKAN PILIHAN DENGAN BENAR ");
            }
        } else if (pilih == 3) {
            System.out.print("NO HP ANDA : ");
            int noHp = scan.nextInt();
            System.out.println("   ========================================   ");
            System.out.println("              KONFIRMASI PEMBAYARAN           ");
            System.out.println("   ========================================   ");
            System.out.println("     NO HP         :  "+noHp);
            System.out.println("     NAMA          :  BANG JAGO");
            System.out.println("     VOUCHER       :  RP. 100.000");
            System.out.println("");
            System.out.println("                                  BAYAR   => 1");
            System.out.println("                                  BATAL   => 2");
            System.out.print("PILIH >>");
            int pilihKonfirmasi = scan.nextInt();
            if (pilihKonfirmasi == 1) {
                persetujuanTransaksi();
            } else if ( pilihKonfirmasi == 2) {
                pembatalanTransaksi();
            } else {
                System.out.println(" MASUKKAN PILIHAN DENGAN BENAR ");
            }
        } else if (pilih == 4) {
            System.out.print("NO HP ANDA : ");
            int noHp = scan.nextInt();
            System.out.println("   ========================================   ");
            System.out.println("              KONFIRMASI PEMBAYARAN           ");
            System.out.println("   ========================================   ");
            System.out.println("     NO HP         :  "+noHp);
            System.out.println("     NAMA          :  BANG JAGO");
            System.out.println("     VOUCHER       :  RP. 150.000");
            System.out.println("");
            System.out.println("                                  BAYAR   => 1");
            System.out.println("                                  BATAL   => 2");
            System.out.print("PILIH >>");
            int pilihKonfirmasi = scan.nextInt();
            if (pilihKonfirmasi == 1) {
                persetujuanTransaksi();
            } else if ( pilihKonfirmasi == 2) {
                pembatalanTransaksi();
            } else {
                System.out.println(" MASUKKAN PILIHAN DENGAN BENAR ");
            }
        } else {
            System.out.println(" MASUKKAN PILIHAN DENGAN BENAR ");
        }

    }

    public void infoSaldo(){
        System.out.println(" ======================================== ");
        System.out.println("\t \n    SISA SAlDO ANDA :  " + saldo);
        System.out.println("\t \n   TEKAN '0' UNTUK KEMBALI KE MENU UTAMA \t \n");
        System.out.println("");
        int pilih = scan.nextInt();
        if (pilih == 0) {
            tampilanMenuUtamaAtm();
        } else {
            System.out.println("Masukkan  Pilihan dengan benar !");
        }
    }

    public void ubahPin(){
        System.out.println("|| ======================================== ||");
        System.out.println("||          MASUKKAN PIN ATM ANDA           ||");
        System.out.println("");
        System.out.print("PIN ANDA : ");
        int pinLama = scan.nextInt();
        String pinLamaa = Integer.toString(pinLama);
        int cekPinLama = pinLamaa.length();
        if (cekPinLama == 6){
            System.out.println("|| ======================================== ||");
            System.out.println("||        MASUKKAN PIN BARU ATM ANDA        ||");
            System.out.println("");
            System.out.print("PIN BARU ANDA : ");
            int pinBaru = scan.nextInt();
            String pinBaruu = Integer.toString(pinBaru);
            int cekPinBaru = pinBaruu.length();
            if (cekPinBaru == 6) {
                System.out.println("|| ======================================== ||");
                System.out.println("             BERHASIL MENGGANTI PIN           ");
                System.out.println("");
                System.out.println("                             MENU UTAMA  => 1 ");
                System.out.println("                             KELUAR      => 2 ");
                int pilih = scan.nextInt();
                if (pilih == 1){
                    tampilanMenuUtamaAtm();
                } else if (pilih == 2){
                    keluar();
                }
            } else {
                System.out.println("MASUKKAN 6 DIGIT PIN BARU ANDA");
                ubahPin();
            }
        } else {
            System.out.println("MASUKKAN 6 DIGIT PIN BARU ANDA");
            ubahPin();
        }

    }

    public void cetakResi(){
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||     APAKAH ANDA INGIN MENCETAK RESI  ?   ||");
        System.out.println("||                                          ||");
        System.out.println("||                                 YA => 1  ||");
        System.out.println("||                              TIDAK => 2  ||");
        System.out.println("||                                          ||");
        System.out.print("PILIH >>");
        int pilih = scan.nextInt();
        if (pilih == 1) {
            pilihanKeluar();
        } else if (pilih == 2) {
            System.out.println();
        } else {
            System.out.println("PILIH DENGAN BENAR !");
        }
    }

    public void persetujuanTransaksi(){
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||              TRANSAKSI BERHASIL          ||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void pembatalanTransaksi(){
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||             TRANSAKSI DIBATALKAN         ||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
        pilihanKeluar();
    }

    public void  pilihanKeluar(){
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||              APAKAH ANDA INGIN           ||");
        System.out.println("||         MELAKUKAN TRANSAKSI LAGI ?       ||");
        System.out.println("||                                          ||");
        System.out.println("||                                  YA => 1 ||");
        System.out.println("||                               TIDAK => 2 ||");
        System.out.println("||                                          ||");
        System.out.println("|| =======================================  ||");
        System.out.print("PILIH >>");
        int pilih = scan.nextInt();
        if (pilih == 1) {
            tampilanMenuUtamaAtm();
        } else if (pilih == 2) {
            keluar();
        } else {
            System.out.println("PILIH DENGAN BENAR !");
        }

    }

    public void keluar(){
        System.out.println("|| ======================================== ||");
        System.out.println("||                                          ||");
        System.out.println("||     TERIMAKASIH ATAS KEPERCAYAAN ANDA    ||");
        System.out.println("||                                          ||");
        System.out.println("|| ======================================== ||");
    }
}


