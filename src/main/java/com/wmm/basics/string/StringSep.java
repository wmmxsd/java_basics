package com.wmm.basics.string;

import java.util.*;
import java.util.stream.Collectors;

public class StringSep {
    public static void main(String[] args) {

        String docEngColumns = "{id}|{FileName}|{KeywordHit}|{fileSecretivelyId}|{IllegalLevel}|{AcessDate}|{FilePath}|{Context}|{ContextList}|{FileSize}|{CreateDate}|{ModifyDate}|{Application}|{FalseAlarm}|{rectifyTime}|{rectifyState}|{judgmentType}";
        String docChColumns = "{编号}|{文件名}|{命中关键字}|{密级}|{违规星级}|{文件疑似度}|{文件路径}|{上下文}|{上下文列表}|{文件大小}|{文件创建时间}|{文件修改时间}|{所属应用}|{误报关键字}|{整改时间}|{整改状态}|{判定类型}";
        String navicatEngColumnNames = "id\tKeywordHit\tjudgmentType\trectifyTime\trectifyState\tContextList\tIllegalLevel\tfileSecretivelyId\tFalseAlarm\tFileName\tFilePath\tFileSize\tCreateDate\tModifyDate\tAcessDate\tContext\tApplication";

        System.out.println("navicat导出的excel的列名转换为syslog格式：" + analyseEngStr(navicatEngColumnNames));
        boolean compareResult = compareStr(docEngColumns, docChColumns, navicatEngColumnNames);
        System.out.println("验证需求文档syslog格式和navicat导出的excel的列名是否完全一致：" + compareResult);

        if (!compareResult) {
            System.out.println("结果不一致，不执行获取中文列名程序");
        }

        System.out.println( printZhStr(docEngColumns, docChColumns, navicatEngColumnNames));
    }

    private static String[] getNewEngColumns(String str, String regex) {
        String[] columnNameArr = str.split(regex);
        return Arrays.stream(columnNameArr).map(s -> "{" + s + "}").toArray(String[]::new);
    }

    private static String analyseEngStr(String str) {
        String[] newColumnNameArr = getNewEngColumns(str, "\t");
        return String.join("|", newColumnNameArr);
    }

    private static boolean compareStr(String docEngColumns, String docChColumns, String excelColumns) {
        List<String> docEngColumnList = Arrays.stream(docEngColumns.split("\\|")).collect(Collectors.toList());
        List<String> docChColumnList = Arrays.stream(docChColumns.split("\\|")).collect(Collectors.toList());
        List<String> excelColumnList = Arrays.stream(excelColumns.split("\t")).map(s -> "{" + s + "}").collect(Collectors.toList());

        if (docEngColumnList.size() != docChColumnList.size()) {
            return false;
        }

        if (docEngColumnList.size() != excelColumnList.size()) {
            return false;
        }

        for (String docColumn : docEngColumnList) {
            if (!excelColumnList.contains(docColumn)) {
                return false;
            }
        }

        return true;
    }

    private static String printZhStr(String docEngColumns, String docChColumns, String excelColumns) {
        List<String> excelZhColumnList = new ArrayList<>();

        List<String> docEngColumnList = Arrays.stream(docEngColumns.split("\\|")).collect(Collectors.toList());
        List<String> docChColumnList = Arrays.stream(docChColumns.split("\\|")).collect(Collectors.toList());
        String[] excelEngColumnList = getNewEngColumns(excelColumns, "\t");

        Map<String, String> engAndZhColumnMap = new HashMap<>();
        for (int index = 0; index < docEngColumnList.size(); index++) {
            engAndZhColumnMap.put(docEngColumnList.get(index), docChColumnList.get(index));
        }

        Arrays.stream(excelEngColumnList).forEach(s -> {
            excelZhColumnList.add(engAndZhColumnMap.get(s));
        });

        return String.join("|", excelZhColumnList);
    }
}
