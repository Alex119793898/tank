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
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			tankD = ImageUtil.rotateImage(tankU,180);
			tankL = ImageUtil.rotateImage(tankU,-90);
			tankR = ImageUtil.rotateImage(tankU,90);

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
