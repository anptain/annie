package com.airball.annie.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingUtils {
	/**
	 * 生成二维码
	 *
	 * @param contents
	 * @param width
	 * @param height
	 * @param imgPath
	 */
	public static byte[] encodeQRCode(String contents, int width, int height) {
		Map<EncodeHintType, Object> hints = new Hashtable<>();
		// 指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		// 指定编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", out);
			return out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析二维码
	 *
	 * @param imgPath
	 * @return
	 */
	public static String decodeQRCode(String imgPath) {
		try {
			byte[] data = FileUtils.readFileToByteArray(new File(imgPath));
			return decodeQRCode(data);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static String decodeQRCode(byte[] data) {
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new ByteArrayInputStream(data));
			if (image == null) {
				System.out.println("the decode image may be not exit.");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			Map<DecodeHintType, Object> hints = new Hashtable<>();
			hints.put(DecodeHintType.CHARACTER_SET, "utf-8");

			result = new MultiFormatReader().decode(bitmap, hints);
			return result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成条形码
	 *
	 * @param contents
	 * @param width
	 * @param height
	 * @param imgPath
	 */
	// int width = 105, height = 50; 长度很容易报错:NotFoundException
	public static byte[] encodeBarCode(String contents, int width, int height) {
		int codeWidth = 3 + // start guard
				(7 * 6) + // left bars
				5 + // middle guard
				(7 * 6) + // right bars
				3; // end guard
		codeWidth = Math.max(codeWidth, width);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.EAN_13, codeWidth, height,
					null);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", out);
			return out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析条形码
	 *
	 * @param imgPath
	 * @return
	 */
	public static String decodeBarCode(String imgPath) {
		
		try {
			byte[] data = FileUtils.readFileToByteArray(new File(imgPath));
			return decodeBarCode(data);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	public static String decodeBarCode(byte[] data) {
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new ByteArrayInputStream(data));
			if (image == null) {
				System.out.println("the decode image may be not exit.");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
			/*
			 * Map<DecodeHintType, Object> hints = new Hashtable<>();
			 * hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
			 * hints.put(DecodeHintType.CHARACTER_SET, "utf-8"); result = new
			 * MultiFormatReader().decode(bitmap, hints);
			 */
			result = new MultiFormatReader().decode(bitmap, null);
			return result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}