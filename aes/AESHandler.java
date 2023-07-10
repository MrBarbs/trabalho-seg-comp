package aes;

import java.util.HexFormat;

import aes.util.MixColumns;
import aes.util.ShiftRow;

public interface AESHandler {
    public final byte[] RCON = HexFormat.of().parseHex("0001020408102040801B366C");
    public final byte[] SBOX = HexFormat.of().parseHex(
            new StringBuilder()
                    .append("637C777BF26B6FC53001672BFED7AB76")
                    .append("CA82C97DFA5947F0ADD4A2AF9CA472C0")
                    .append("B7FD9326363FF7CC34A5E5F171D83115")
                    .append("04C723C31896059A071280E2EB27B275")
                    .append("09832C1A1B6E5AA0523BD6B329E32F84")
                    .append("53D100ED20FCB15B6ACBBE394A4C58CF")
                    .append("D0EFAAFB434D338545F9027F503C9FA8")
                    .append("51A3408F929D38F5BCB6DA2110FFF3D2")
                    .append("CD0C13EC5F974417C4A77E3D645D1973")
                    .append("60814FDC222A908846EEB814DE5E0BDB")
                    .append("E0323A0A4906245CC2D3AC629195E479")
                    .append("E7C8376D8DD54EA96C56F4EA657AAE08")
                    .append("BA78252E1CA6B4C6E8DD741F4BBD8B8A")
                    .append("703EB5664803F60E613557B986C11D9E")
                    .append("E1F8981169D98E949B1E87E9CE5528DF")
                    .append("8CA1890DBFE6426841992D0FB054BB16")
                    .toString());

    public interface Encrypt {
        public static byte[] subBytes(byte[] key) {
            byte[] result = new byte[key.length];

            for (int i = 0; i < key.length; i++) {
                result[i] = SBOX[key[i]];
            }

            return result;
        } // ok

        public static byte[] shiftRows(byte[] key) {
            byte[][] rows = ShiftRow.convertKeyToRows(key);

            rows = ShiftRow.rowShift(rows);

            return ShiftRow.convertRowsToKey(rows);
        } // ok

        public static byte[] mixColumns(byte[] key) {
            byte[][] columns = MixColumns.convertKeyToColumns(key);

            columns = columnMixer(columns);

            return MixColumns.convertColumnsToKey(columns);
        }

        public static byte[][] columnMixer(byte[][] columns) {
            byte[][] newColumns = new byte[4][4];
            for (int i = 0; i < 4; i++) {
                newColumns[i] = columns[i].clone();
            }

            for (int i = 0; i < 4; i++) {
                byte[] temp = columns[i];

            }

            return columns;
        }

        public static byte[] xorRoundKeys(byte[] key) {
            // to be implemented
            return new byte[] {};
        }

        private static byte[] roundsTwoToTen(byte[] key) {
            // to be implemented
            return new byte[] {};
        }

        public static byte[] generateRoundKeys(byte[] key0) {

            return new byte[] {};
        }
    }
}
