package com.manong.controller;

import com.google.code.kaptcha.Producer;
import com.manong.utils.RedisUtils;
import com.manong.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 验证码控制器
 */
@RestController
@RequestMapping("/captchaImage")
public class CaptchaController {

    @Autowired
    private Producer producer;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping
    public ResultVo getCode(HttpServletRequest request) {
        // 1. 生成验证码文本
        String code = producer.createText();
        // 2. 生成验证码图片
        BufferedImage image = producer.createImage(code);
        // 3. 将验证码文本保存到Redis，并设置过期时间
        String uuid = UUID.randomUUID().toString();
        redisUtils.set(uuid, code, 60 * 5); // 5分钟过期

        // 4. 将验证码图片转为Base64
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            BASE64Encoder encoder = new BASE64Encoder();
            String base64 = "data:image/jpeg;base64," + encoder.encode(outputStream.toByteArray());
            Map<String, Object> result = new HashMap<>();
            result.put("uuid", uuid);
            result.put("img", base64);
            return ResultVo.success("成功", result);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultVo.fail("验证码生成失败");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}