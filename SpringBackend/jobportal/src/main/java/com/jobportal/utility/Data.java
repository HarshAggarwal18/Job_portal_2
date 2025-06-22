package com.jobportal.utility;

public class Data {


        public static String getMessageBody(String recipientName, String otpCode, String companyName) {
            return "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Your One-Time Password (OTP)</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: 'Arial', sans-serif;\n" +
                    "            line-height: 1.6;\n" +
                    "            color: #333333;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            background-color: #f4f4f4;\n" +
                    "        }\n" +
                    "        .container {\n" +
                    "            max-width: 600px;\n" +
                    "            margin: 20px auto;\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #ffffff;\n" +
                    "            border-radius: 8px;\n" +
                    "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                    "        }\n" +
                    "        .header {\n" +
                    "            text-align: center;\n" +
                    "            padding: 10px 0;\n" +
                    "            border-bottom: 1px solid #eeeeee;\n" +
                    "        }\n" +
                    "        .logo {\n" +
                    "            max-width: 150px;\n" +
                    "            height: auto;\n" +
                    "        }\n" +
                    "        .content {\n" +
                    "            padding: 20px;\n" +
                    "        }\n" +
                    "        .otp-container {\n" +
                    "            margin: 30px 0;\n" +
                    "            text-align: center;\n" +
                    "        }\n" +
                    "        .otp-code {\n" +
                    "            display: inline-block;\n" +
                    "            font-size: 28px;\n" +
                    "            font-weight: bold;\n" +
                    "            letter-spacing: 5px;\n" +
                    "            padding: 15px 25px;\n" +
                    "            background-color: #f8f8f8;\n" +
                    "            border-radius: 5px;\n" +
                    "            color: #2c3e50;\n" +
                    "            border: 1px dashed #cccccc;\n" +
                    "        }\n" +
                    "        .footer {\n" +
                    "            text-align: center;\n" +
                    "            padding: 20px;\n" +
                    "            font-size: 12px;\n" +
                    "            color: #777777;\n" +
                    "            border-top: 1px solid #eeeeee;\n" +
                    "        }\n" +
                    "        .button {\n" +
                    "            display: inline-block;\n" +
                    "            padding: 10px 20px;\n" +
                    "            background-color: #3498db;\n" +
                    "            color: #ffffff;\n" +
                    "            text-decoration: none;\n" +
                    "            border-radius: 5px;\n" +
                    "            margin: 10px 0;\n" +
                    "        }\n" +
                    "        .note {\n" +
                    "            background-color: #fff8e1;\n" +
                    "            padding: 15px;\n" +
                    "            border-left: 4px solid #ffc107;\n" +
                    "            margin: 20px 0;\n" +
                    "            font-size: 14px;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <div class=\"header\">\n" +
                    "            <img src=\"https://example.com/logo.png\" alt=\"" + companyName + " Logo\" class=\"logo\">\n" +
                    "        </div>\n" +
                    "        \n" +
                    "        <div class=\"content\">\n" +
                    "            <h2>Your One-Time Password (OTP)</h2>\n" +
                    "            <p>Hello " + recipientName + ",</p>\n" +
                    "            <p>We received a request to access your account. Please use the following One-Time Password to verify your identity:</p>\n" +
                    "            \n" +
                    "            <div class=\"otp-container\">\n" +
                    "                <div class=\"otp-code\">" + otpCode + "</div>\n" +
                    "            </div>\n" +
                    "            \n" +
                    "            <p>This OTP is valid for <strong>10 minutes</strong>. Please do not share this code with anyone.</p>\n" +
                    "            \n" +
                    "            <div class=\"note\">\n" +
                    "                <p><strong>Note:</strong> If you didn't request this OTP, please ignore this email or contact our support team immediately at <a href=\"mailto:support@example.com\">support@example.com</a>.</p>\n" +
                    "            </div>\n" +
                    "            \n" +
                    "            <p>For security reasons, we recommend:</p>\n" +
                    "            <ul>\n" +
                    "                <li>Never sharing your OTP with anyone</li>\n" +
                    "                <li>Changing your password regularly</li>\n" +
                    "                <li>Enabling two-factor authentication</li>\n" +
                    "            </ul>\n" +
                    "            \n" +
                    "            <p>If you need any assistance, please don't hesitate to contact our support team.</p>\n" +
                    "            \n" +
                    "            <p>Best regards,<br>\n" +
                    "            " + companyName + " Team</p>\n" +
                    "        </div>\n" +
                    "        \n" +
                    "        <div class=\"footer\">\n" +
                    "            <p>&copy; 2023 " + companyName + ". All rights reserved.</p>\n" +
                    "            <p>\n" +
                    "                123 Company Street | \n" +
                    "                <a href=\"https://example.com/privacy\">Privacy Policy</a> | \n" +
                    "                <a href=\"https://example.com/terms\">Terms of Service</a>\n" +
                    "            </p>\n" +
                    "            <p>\n" +
                    "                <a href=\"https://example.com/unsubscribe\">Unsubscribe</a> from these emails\n" +
                    "            </p>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>";
        }



}
