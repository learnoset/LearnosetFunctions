package com.learnoset.functions;

import android.content.Context;

import com.learnoset.networking.LearnosetNetRequest;
import com.learnoset.networking.NetResponseListener;
import com.learnoset.networking.RequestMethod;

import org.json.JSONArray;
import org.json.JSONException;

public class LearnosetStrings {

    private static StringsEventListener successListener = null;
    // Memory
    private static String USER_ID_TXT = "";
    private static String PASSWORD_TXT = "";
    private static String MAIN_DATA_TXT = "";
    private static String USER_DATA_TXT = "";
    // Toast
    private static String PLEASE_ENTER_OTP = "";
    private static String SOMETHING_WENT_WRONG = "";
    private static String ALL_FIELDS_REQUIRED = "";
    private static String PASSWORD_NOT_MATCHING = "";
    private static String INVALID_OTP = "";
    private static String INCORRECT_DETAILS = "";
    private static String INCORRECT_PASSWORD = "";
    private static String INCORRECT_EMAIL = "";
    private static String INCORRECT_MOBILE = "";
    private static String PLEASE_WAIT = "";
    private static String DATA_IS_LOADING = "";
    private static String DATA_LOADED = "";
    private static String DATA_LOADED_SUCCESSFULLY = "";
    private static String PLEASE_WAIT_FOR_SOME_TIME = "";
    private static String MOBILE_ALREADY_EXISTS = "";
    private static String EMAIL_ALREADY_EXISTS = "";
    private static String SUCCESS = "";
    private static String SUCCESSFUL = "";
    private static String PLEASE_ENTER_MOBILE_NUMBER = "";
    private static String PLEASE_ENTER_PHONE_NUMBER = "";
    private static String PLEASE_ENTER_MOBILE_AND_PASSWORD = "";
    private static String MOBILE_AND_PASSWORD = "";
    private static String INCORRECT_MOBILE_OR_PASSWORD = "";
    private static String SELECT_PAYMENT_METHOD = "";
    private static String CAMERA_PER_DENIED = "";
    private static String PLEASE_GIVE_RATE = "";
    private static String REVIEW_SUBMITTED = "";
    private static String TYPE_SOMETHING = "";
    private static String PERMISSIONS_DENIED = "";
    private static String PERMISSIONS_ACCESS = "";
    // Others
    private static String PLEASE = "";
    private static String OPEN = "";
    private static String CLOSE = "";
    private static String FROM = "";
    private static String ID = "";
    private static String GATEWAY = "";
    private static String APK = "";
    private static String ANDROID = "";
    private static String VERSION = "";
    private static String EMAIL = "";
    private static String MOBILE = "";
    private static String PHONE = "";
    private static String PASSWORD = "";
    private static String OTP = "";
    private static String FULL_NAME = "";
    private static String FULLNAME = "";
    private static String NAME = "";
    private static String ADDRESS = "";
    private static String VERIFY = "";
    private static String SEND = "";
    private static String SENT = "";
    private static String CATEGORY = "";
    private static String CATEGORIES = "";
    private static String USER = "";
    private static String USERS = "";
    private static String USER_ID = "";
    private static String IMAGE = "";
    private static String PHOTO = "";
    private static String PROCESS = "";
    private static String PROCESSING = "";
    private static String TYPE = "";
    private static String TYPES = "";
    private static String IMAGES = "";
    private static String PHOTOS = "";
    private static String ABOUT = "";
    private static String ABOUT_UD = "";
    private static String RATE_US = "";
    private static String REACH_US = "";
    private static String CONTACT_US = "";
    private static String FEES = "";
    private static String DURATION = "";
    private static String TOKEN = "";
    private static String LOGIN_ID = "";
    private static String ACCESS = "";
    private static String TITLE = "";
    private static String MESSAGE = "";
    private static String MSG = "";
    private static String MESSAGES = "";
    private static String SUBSCRIPTION = "";
    private static String PREMIUM = "";
    private static String UPDATE = "";
    private static String NOW = "";
    private static String UPDATE_NOW = "";
    private static String TODAY = "";
    private static String YESTERDAY = "";
    private static String DATE = "";
    private static String TIME = "";
    private static String DATE_TIME = "";
    private static String DISCUSS = "";
    private static String DISCUSSION = "";
    private static String PROBLEM = "";
    private static String PROBLEMS = "";
    private static String TERMS = "";
    private static String CONDITIONS = "";
    private static String CONDITION = "";
    private static String REPORT = "";
    private static String ERROR = "";
    private static String COMMISSION = "";
    private static String SHARE = "";
    private static String REFERRAL = "";
    private static String APP_LINK = "";
    private static String WEBSITE_LINK = "";
    private static String SHARE_TXT = "";
    private static String FILENAME = "";
    private static String DATA = "";
    private static String FILENAMES = "";
    private static String SUBJECTS = "";
    private static String SUBJECT = "";
    private static String DESTINATION = "";
    private static String SOURCE = "";
    private static String ACTION = "";
    private static String DELETE = "";
    private static String UPLOADING = "";
    private static String LOCAL = "";
    private static String PROFILE_PIC = "";
    private static String UPLOAD = "";
    private static String BONUS = "";
    private static String POINTS = "";
    private static String POST = "";
    private static String GET = "";
    private static String METHOD = "";
    private static String EARN = "";
    private static String EARNING = "";
    private static String EARNINGS = "";
    private static String DEVELOP = "";
    private static String DEVELOPMENT = "";
    private static String INSTAGRAM = "";
    private static String WHATSAPP = "";
    private static String GMAIL = "";
    private static String FACEBOOK = "";
    private static String LEARNOSSET = "";
    private static String TWITTER = "";
    private static String SNAPCHAT = "";
    private static String RUNNING = "";
    private static String REGISTER = "";
    private static String SEARCH = "";
    private static String SEARCHING = "";
    private static String DATABASE = "";
    private static String CODE = "";
    private static String ICON = "";
    private static String ICONS = "";
    private static String DOWNLOAD = "";
    private static String NOTIFICATION = "";
    private static String NOTIFICATIONS = "";

    public static void init(Context context, String fileURL, StringsEventListener successListener) {
        LearnosetStrings.successListener = successListener;

        init(context, fileURL);
    }

    public static void init(Context context, String fileURL) {

        LearnosetNetRequest learnosetNetRequest = new LearnosetNetRequest(context, fileURL, RequestMethod.GET);
        learnosetNetRequest.execute(false, 1, new NetResponseListener() {
            @Override
            public void onRequestSuccess(String response, Context context, int resultCode) {
                try {
                    final JSONArray jsonArray = new JSONArray(response);

                    MemoryFunctions.saveData("str.txt", jsonArray.toString(), context);

                    assigningData(jsonArray);

                    if (LearnosetStrings.successListener != null) {
                        LearnosetStrings.successListener.success();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (LearnosetStrings.successListener != null) {
                        LearnosetStrings.successListener.failed(e.getMessage());
                    }
                }
            }

            @Override
            public void onRequestFailed(String errorMessage, Context context, int resultCode) {
                if (LearnosetStrings.successListener != null) {
                    LearnosetStrings.successListener.failed(errorMessage);
                }
            }
        });
    }

    public static void refreshStrings(Context context) {
        if (PLEASE_ENTER_OTP.isEmpty() ||
                SUBJECT.isEmpty() ||
                DEVELOPMENT.isEmpty() ||
                PHOTO.isEmpty() ||
                OTP.isEmpty() ||
                FROM.isEmpty() ||
                PASSWORD_NOT_MATCHING.isEmpty() ||
                PLEASE_WAIT.isEmpty() ||
                TOKEN.isEmpty() ||
                APP_LINK.isEmpty() ||
                UPDATE_NOW.isEmpty() ||
                FILENAME.isEmpty() ||
                TIME.isEmpty() ||
                MESSAGES.isEmpty() ||
                ACCESS.isEmpty() ||
                USER_ID_TXT.isEmpty() ||
                PASSWORD_TXT.isEmpty() ||
                MAIN_DATA_TXT.isEmpty() ||
                USER_DATA_TXT.isEmpty() ||
                SUCCESS.isEmpty() ||
                GET.isEmpty() ||
                RUNNING.isEmpty() ||
                NOTIFICATION.isEmpty() ||
                SEARCH.isEmpty() ||
                DATABASE.isEmpty() ||
                FACEBOOK.isEmpty() ||
                DELETE.isEmpty()

        ) {
            try {
                assigningData(MemoryFunctions.getDataInJSOArrayForm("str.txt", context));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void assigningData(JSONArray jsonArray) throws JSONException {

        for (int i = 0; i < jsonArray.length(); i++) {
            if (i == 0) {
                USER_ID_TXT = jsonArray.getString(i);
            } else if (i == 1) {
                PASSWORD_TXT = jsonArray.getString(i);
            } else if (i == 2) {
                MAIN_DATA_TXT = jsonArray.getString(i);
            } else if (i == 3) {
                USER_DATA_TXT = jsonArray.getString(i);
            } else if (i == 4) {
                PLEASE_ENTER_OTP = jsonArray.getString(i);
            } else if (i == 5) {
                SOMETHING_WENT_WRONG = jsonArray.getString(i);
            } else if (i == 6) {
                ALL_FIELDS_REQUIRED = jsonArray.getString(i);
            } else if (i == 7) {
                PASSWORD_NOT_MATCHING = jsonArray.getString(i);
            } else if (i == 8) {
                INVALID_OTP = jsonArray.getString(i);
            } else if (i == 9) {
                INCORRECT_DETAILS = jsonArray.getString(i);
            } else if (i == 10) {
                INCORRECT_PASSWORD = jsonArray.getString(i);
            } else if (i == 11) {
                INCORRECT_EMAIL = jsonArray.getString(i);
            } else if (i == 12) {
                INCORRECT_MOBILE = jsonArray.getString(i);
            } else if (i == 13) {
                PLEASE_WAIT = jsonArray.getString(i);
            } else if (i == 14) {
                DATA_IS_LOADING = jsonArray.getString(i);
            } else if (i == 15) {
                DATA_LOADED = jsonArray.getString(i);
            } else if (i == 16) {
                DATA_LOADED_SUCCESSFULLY = jsonArray.getString(i);
            } else if (i == 17) {
                PLEASE_WAIT_FOR_SOME_TIME = jsonArray.getString(i);
            } else if (i == 18) {
                MOBILE_ALREADY_EXISTS = jsonArray.getString(i);
            } else if (i == 19) {
                EMAIL_ALREADY_EXISTS = jsonArray.getString(i);
            } else if (i == 20) {
                SUCCESS = jsonArray.getString(i);
            } else if (i == 21) {
                SUCCESSFUL = jsonArray.getString(i);
            } else if (i == 22) {
                PLEASE_ENTER_MOBILE_NUMBER = jsonArray.getString(i);
            } else if (i == 23) {
                PLEASE_ENTER_PHONE_NUMBER = jsonArray.getString(i);
            } else if (i == 24) {
                PLEASE_ENTER_MOBILE_AND_PASSWORD = jsonArray.getString(i);
            } else if (i == 25) {
                MOBILE_AND_PASSWORD = jsonArray.getString(i);
            } else if (i == 26) {
                INCORRECT_MOBILE_OR_PASSWORD = jsonArray.getString(i);
            } else if (i == 27) {
                SELECT_PAYMENT_METHOD = jsonArray.getString(i);
            } else if (i == 28) {
                CAMERA_PER_DENIED = jsonArray.getString(i);
            } else if (i == 29) {
                PLEASE_GIVE_RATE = jsonArray.getString(i);
            } else if (i == 30) {
                REVIEW_SUBMITTED = jsonArray.getString(i);
            } else if (i == 31) {
                TYPE_SOMETHING = jsonArray.getString(i);
            } else if (i == 32) {
                PERMISSIONS_DENIED = jsonArray.getString(i);
            } else if (i == 33) {
                PERMISSIONS_ACCESS = jsonArray.getString(i);
            } else if (i == 34) {
                PLEASE = jsonArray.getString(i);
            } else if (i == 35) {
                OPEN = jsonArray.getString(i);
            } else if (i == 36) {
                CLOSE = jsonArray.getString(i);
            } else if (i == 37) {
                FROM = jsonArray.getString(i);
            } else if (i == 38) {
                ID = jsonArray.getString(i);
            } else if (i == 39) {
                GATEWAY = jsonArray.getString(i);
            } else if (i == 40) {
                APK = jsonArray.getString(i);
            } else if (i == 41) {
                ANDROID = jsonArray.getString(i);
            } else if (i == 42) {
                VERSION = jsonArray.getString(i);
            } else if (i == 43) {
                EMAIL = jsonArray.getString(i);
            } else if (i == 44) {
                MOBILE = jsonArray.getString(i);
            } else if (i == 45) {
                PHONE = jsonArray.getString(i);
            } else if (i == 46) {
                PASSWORD = jsonArray.getString(i);
            } else if (i == 47) {
                OTP = jsonArray.getString(i);
            } else if (i == 48) {
                FULL_NAME = jsonArray.getString(i);
            } else if (i == 49) {
                FULLNAME = jsonArray.getString(i);
            } else if (i == 50) {
                NAME = jsonArray.getString(i);
            } else if (i == 51) {
                ADDRESS = jsonArray.getString(i);
            } else if (i == 52) {
                VERIFY = jsonArray.getString(i);
            } else if (i == 53) {
                SEND = jsonArray.getString(i);
            } else if (i == 54) {
                SENT = jsonArray.getString(i);
            } else if (i == 55) {
                CATEGORY = jsonArray.getString(i);
            } else if (i == 56) {
                CATEGORIES = jsonArray.getString(i);
            } else if (i == 57) {
                USER = jsonArray.getString(i);
            } else if (i == 58) {
                USERS = jsonArray.getString(i);
            } else if (i == 59) {
                USER_ID = jsonArray.getString(i);
            } else if (i == 60) {
                IMAGE = jsonArray.getString(i);
            } else if (i == 61) {
                PHOTO = jsonArray.getString(i);
            } else if (i == 62) {
                PROCESS = jsonArray.getString(i);
            } else if (i == 63) {
                PROCESSING = jsonArray.getString(i);
            } else if (i == 64) {
                TYPE = jsonArray.getString(i);
            } else if (i == 65) {
                TYPES = jsonArray.getString(i);
            } else if (i == 66) {
                IMAGES = jsonArray.getString(i);
            } else if (i == 67) {
                PHOTOS = jsonArray.getString(i);
            } else if (i == 68) {
                ABOUT = jsonArray.getString(i);
            } else if (i == 69) {
                ABOUT_UD = jsonArray.getString(i);
            } else if (i == 70) {
                RATE_US = jsonArray.getString(i);
            } else if (i == 71) {
                REACH_US = jsonArray.getString(i);
            } else if (i == 72) {
                CONTACT_US = jsonArray.getString(i);
            } else if (i == 73) {
                FEES = jsonArray.getString(i);
            } else if (i == 74) {
                DURATION = jsonArray.getString(i);
            } else if (i == 75) {
                TOKEN = jsonArray.getString(i);
            } else if (i == 76) {
                LOGIN_ID = jsonArray.getString(i);
            } else if (i == 77) {
                ACCESS = jsonArray.getString(i);
            } else if (i == 78) {
                TITLE = jsonArray.getString(i);
            } else if (i == 79) {
                MESSAGE = jsonArray.getString(i);
            } else if (i == 80) {
                MSG = jsonArray.getString(i);
            } else if (i == 81) {
                MESSAGES = jsonArray.getString(i);
            } else if (i == 82) {
                SUBSCRIPTION = jsonArray.getString(i);
            } else if (i == 83) {
                PREMIUM = jsonArray.getString(i);
            } else if (i == 84) {
                UPDATE = jsonArray.getString(i);
            } else if (i == 85) {
                NOW = jsonArray.getString(i);
            } else if (i == 86) {
                UPDATE_NOW = jsonArray.getString(i);
            } else if (i == 87) {
                TODAY = jsonArray.getString(i);
            } else if (i == 88) {
                YESTERDAY = jsonArray.getString(i);
            } else if (i == 89) {
                DATE = jsonArray.getString(i);
            } else if (i == 90) {
                TIME = jsonArray.getString(i);
            } else if (i == 91) {
                DATE_TIME = jsonArray.getString(i);
            } else if (i == 92) {
                DISCUSS = jsonArray.getString(i);
            } else if (i == 93) {
                DISCUSSION = jsonArray.getString(i);
            } else if (i == 94) {
                PROBLEM = jsonArray.getString(i);
            } else if (i == 95) {
                PROBLEMS = jsonArray.getString(i);
            } else if (i == 96) {
                TERMS = jsonArray.getString(i);
            } else if (i == 97) {
                CONDITIONS = jsonArray.getString(i);
            } else if (i == 98) {
                CONDITION = jsonArray.getString(i);
            } else if (i == 99) {
                REPORT = jsonArray.getString(i);
            } else if (i == 100) {
                ERROR = jsonArray.getString(i);
            } else if (i == 101) {
                COMMISSION = jsonArray.getString(i);
            } else if (i == 102) {
                SHARE = jsonArray.getString(i);
            } else if (i == 103) {
                REFERRAL = jsonArray.getString(i);
            } else if (i == 104) {
                APP_LINK = jsonArray.getString(i);
            } else if (i == 105) {
                WEBSITE_LINK = jsonArray.getString(i);
            } else if (i == 106) {
                SHARE_TXT = jsonArray.getString(i);
            } else if (i == 107) {
                FILENAME = jsonArray.getString(i);
            } else if (i == 108) {
                DATA = jsonArray.getString(i);
            } else if (i == 109) {
                FILENAMES = jsonArray.getString(i);
            } else if (i == 110) {
                SUBJECTS = jsonArray.getString(i);
            } else if (i == 111) {
                SUBJECT = jsonArray.getString(i);
            } else if (i == 112) {
                DESTINATION = jsonArray.getString(i);
            } else if (i == 113) {
                SOURCE = jsonArray.getString(i);
            } else if (i == 114) {
                ACTION = jsonArray.getString(i);
            } else if (i == 115) {
                DELETE = jsonArray.getString(i);
            } else if (i == 116) {
                UPLOADING = jsonArray.getString(i);
            } else if (i == 117) {
                LOCAL = jsonArray.getString(i);
            } else if (i == 118) {
                PROFILE_PIC = jsonArray.getString(i);
            } else if (i == 119) {
                UPLOAD = jsonArray.getString(i);
            } else if (i == 120) {
                BONUS = jsonArray.getString(i);
            } else if (i == 121) {
                POINTS = jsonArray.getString(i);
            } else if (i == 122) {
                POST = jsonArray.getString(i);
            } else if (i == 123) {
                GET = jsonArray.getString(i);
            } else if (i == 124) {
                METHOD = jsonArray.getString(i);
            } else if (i == 125) {
                EARN = jsonArray.getString(i);
            } else if (i == 126) {
                EARNING = jsonArray.getString(i);
            } else if (i == 127) {
                EARNINGS = jsonArray.getString(i);
            } else if (i == 128) {
                DEVELOP = jsonArray.getString(i);
            } else if (i == 129) {
                DEVELOPMENT = jsonArray.getString(i);
            } else if (i == 130) {
                INSTAGRAM = jsonArray.getString(i);
            } else if (i == 131) {
                WHATSAPP = jsonArray.getString(i);
            } else if (i == 132) {
                GMAIL = jsonArray.getString(i);
            } else if (i == 133) {
                FACEBOOK = jsonArray.getString(i);
            } else if (i == 134) {
                LEARNOSSET = jsonArray.getString(i);
            } else if (i == 135) {
                TWITTER = jsonArray.getString(i);
            } else if (i == 136) {
                SNAPCHAT = jsonArray.getString(i);
            } else if (i == 137) {
                RUNNING = jsonArray.getString(i);
            } else if (i == 138) {
                REGISTER = jsonArray.getString(i);
            } else if (i == 139) {
                SEARCH = jsonArray.getString(i);
            } else if (i == 140) {
                SEARCHING = jsonArray.getString(i);
            } else if (i == 141) {
                DATABASE = jsonArray.getString(i);
            } else if (i == 142) {
                CODE = jsonArray.getString(i);
            } else if (i == 143) {
                ICON = jsonArray.getString(i);
            } else if (i == 144) {
                ICONS = jsonArray.getString(i);
            } else if (i == 145) {
                DOWNLOAD = jsonArray.getString(i);
            } else if (i == 146) {
                NOTIFICATION = jsonArray.getString(i);
            } else if (i == 147) {
                NOTIFICATIONS = jsonArray.getString(i);
            }

        }

    }

    public static String firstLetterCapital(String rawString) {
        return rawString.substring(0, 1).toUpperCase() + rawString.substring(1);
    }

    public static String removeUnderScore(String rawString) {
        return rawString.replaceAll("_", "");
    }

    public static String underScoreToSpace(String rawString) {
        return rawString.replaceAll("_", " ");
    }

    public static String firstLetterCapitalAllWords(String rawStringWithUnderScore) {
        String[] allWords = rawStringWithUnderScore.split("_");
        String formattedStr = "";

        for (String allWord : allWords) {
            if (formattedStr.isEmpty()) {
                formattedStr = firstLetterCapital(allWord);
            } else {
                formattedStr = " " + firstLetterCapital(allWord);
            }
        }
        return formattedStr;
    }
}
