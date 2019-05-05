package com.caoliang.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
	public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;

	public static BufferedImage badTankL, badTankU, badTankR, badTankD;

	public static BufferedImage bulletL, bulletU, bulletR, bulletD;

	public static BufferedImage[] baoZha = new BufferedImage[16];

	static {
		try {
			goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankD = ImageUtil.rotateImage(goodTankU,180);
			goodTankL = ImageUtil.rotateImage(goodTankU,-90);
			goodTankR = ImageUtil.rotateImage(goodTankU,90);

			badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankD = ImageUtil.rotateImage(badTankU,180);
			badTankL = ImageUtil.rotateImage(badTankU,-90);
			badTankR = ImageUtil.rotateImage(badTankU,90);

			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletD = ImageUtil.rotateImage(bulletU,180);
			bulletL = ImageUtil.rotateImage(bulletU,-90);
			bulletR = ImageUtil.rotateImage(bulletU,90);

			for(int i =0; i<16; i++){
				baoZha[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
