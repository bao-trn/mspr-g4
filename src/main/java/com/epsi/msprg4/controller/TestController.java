package com.epsi.msprg4.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class TestController {


    @GetMapping("/test")
    public String getString() {
        return "this is a string";
    }

    @PostMapping ("/qr")
    public void foo() throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("this is a qr code SBBRRRRRR", BarcodeFormat.QR_CODE, 100, 100);

        FileOutputStream fileInputStream = new FileOutputStream("src/main/resources/qrcodetest.png");
        MatrixToImageWriter.writeToStream(bitMatrix, "png", fileInputStream);
    }
}
