package aes.util;

import java.util.HexFormat;

public interface SubBytes {

    byte[] SBOX = HexFormat.of().parseHex(
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

    public final byte[] REVERSE_SBOX = HexFormat.of().parseHex(
            new StringBuilder()
                    .append("52096AD53036A538BF40A39E81F3D7FB")
                    .append("7CE339829B2FFF87348E4344C4DEE9CB")
                    .append("547B9432A6C2233DEE4C950B42FAC34E")
                    .append("082EA16628D924B2765BA2496D8BD125")
                    .append("72F8F66486689816D4A45CCC5D65B692")
                    .append("6C704850FDFFF22E7ADD057DCCDAA09B")
                    .append("E7933FDC8D0110FCE94B16DFA50F9DF2")
                    .append("9ABF126A0E91EE4D7804E22E6BC4AFC3")
                    .append("A029F4FB61D003DFA0FEE00B1561904E")
                    .append("70E57284E3D46B3F7706A5D4AAB8CDBA")
                    .append("E90D208D2FBB89B6ED501ABD07D1A30B")
                    .append("D971D112B2FCC3D04DEB047A6A3B3E7F")
                    .append("1FFDCE0CEF4C9844E3B8DA6DCAEBCEDF")
                    .append("7897AB07F9759615F411D0E14F97B972")
                    .append("090A1DB07EBE1F47E6F030D4F4722789")
                    .append("4C98A0BEAC8D59E1E8DCE2C9F7F0F67D")
                    .toString());

}
