package com.caoliang.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;

	public static BufferedImage[] baoZha = new BufferedImage[16];

	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankU = ImageUtil.rotateImage(tankL,90);
			tankR = ImageUtil.rotateImage(tankL,180);
			tankD = ImageUtil.rotateImage(tankL,-90);

			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletR = ImageUtil.rotateImage(bulletL,180);
			bulletU = ImageUtil.rotateImage(bulletL,90);
			bulletD = ImageUtil.rotateImage(bulletL,-90);

			for(int i =0; i<16; i++){
				baoZha[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
