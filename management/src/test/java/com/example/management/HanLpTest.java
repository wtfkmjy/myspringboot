package com.example.management;

import com.example.management.utils.ClassifierConstant;
import com.example.management.utils.HanLpClassifier;

public class HanLpTest {
    public static void main(String[] args) {
        HanLpClassifier.initClassifier(ClassifierConstant.DATASET_WEIBO_PATH, ClassifierConstant.WEIBO_MODEL_PATH);
        System.out.println(HanLpClassifier.getClassification("天安门"));
        System.out.println(HanLpClassifier.getClassification("哇哦今年的春夏季衣服不错诶"));
        System.out.println(HanLpClassifier.getClassification("去死吧"));
        System.out.println(HanLpClassifier.getClassification("加油"));
        System.out.println(HanLpClassifier.getClassification("你真好"));
        System.out.println(HanLpClassifier.getScoreOfWeiboComment("你真好"));

        HanLpClassifier.initClassifier(ClassifierConstant.DATASET_HOTEL_PATH, ClassifierConstant.HOTEL_MODEL_PATH);
        System.out.println(HanLpClassifier.getClassification("酒店太差了"));

        HanLpClassifier.initClassifier(ClassifierConstant.DATASET_SOUGOU_PATH, ClassifierConstant.SOUGOU_MODEL_PATH);
        System.out.println(HanLpClassifier.getClassification("篮球、羽毛球"));
    }
}
