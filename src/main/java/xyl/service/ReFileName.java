package xyl.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReFileName {

    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop\\新建文件夹 (2)";
        new ReFileName().reName(path);
    }

    public void reName(String path){
        File file = new File(path);
        if(!file.isDirectory()){
            System.out.println("输入路径不是文件夹路径");
            return;
        }
        Map<String,String> newNameMap = new HashMap<>();
/*        newNameMap.put("002","系统中存在，银行不存在");
        newNameMap.put("003-1","银行提交的数据，系统中不存在，银行存在");
        newNameMap.put("003","银行提交的数据，系统中在其他银行存在，银行存在");
        newNameMap.put("004","系统中存在多笔贷款或存在多对多的情况");
        newNameMap.put("005","总账表的贷款金额!=贷款余额+逾期本金+已实还本金");
        newNameMap.put("006","总账表的贷款期数!=已还期数+逾期期数+剩余期数");
        newNameMap.put("007","总账表的回收本金!=明细表还款本金合计");
        newNameMap.put("008","总账表的回收利息!=明细表还款利息合计");
        newNameMap.put("009","（总账表的累计逾期本金-逾期本金）!=明细表业务类型为还逾期的本金的合计");
        newNameMap.put("010","总账表的累计逾期利息-逾期利息!=（明细表业务类型为还逾期的利息）的合计");
        newNameMap.put("011","总账表的罚息金额!=明细表的罚息金额合计");
        newNameMap.put("012","逾期明细的逾期本金!=总账表的累计逾期本金");
        newNameMap.put("013","逾期明细的逾期利息!=总账表的累计逾期利息");
        newNameMap.put("014","逾期明细的逾期本金-实还逾期本金!=总账表的逾期本金");
        newNameMap.put("015","逾期明细的逾期利息-实还逾期利息!=总账表的逾期利息");
        newNameMap.put("016","总账表剩余期数不等于总账表贷款期数减去还款明细表的还款笔数");
        newNameMap.put("023","贷款利率不正确");*/

        setMap(newNameMap);

        String dirPath = path+"/";
        String[] list = file.list();
        int num=0;
        for (String file_:list){
            String nkey = file_.substring(0,file_.lastIndexOf("."));
            String newName = newNameMap.get(nkey);
            if(newName != null){
                File fileOld = new File(dirPath+file_);
                File fileNew = new File(dirPath+newName+file_.substring(file_.lastIndexOf(".")));
                fileOld.renameTo(fileNew);
                num++;
            }

        }
        System.out.println("完成"+num+"个文件的名称修改");
    }

    public void setMap(Map<String,String> newNameMap){

        newNameMap.put("01001","01001-建行右江支行");
        newNameMap.put("01002","01002-中国建设银行股份有限公司田阳支行");
        newNameMap.put("01003","01003-中国建设银行股份有限公司田东支行");
        newNameMap.put("01004","01004-建行平果支行");
        newNameMap.put("01005","01005-中国建设银行股份有限公司德保县桂西华银铝支行");
        newNameMap.put("01006","01006-中国建设银行股份有限公司靖西支行");
        newNameMap.put("01007","01007-建行那坡支行");
        newNameMap.put("01008","01008-建行凌云支行");
        newNameMap.put("01009","01009-中国建设银行百色市分行");
        newNameMap.put("01010","01010-中国建设银行股份有限公司平果铝分行");
        newNameMap.put("02001","02001-中国工商银行百色市右江支行");
        newNameMap.put("02002","02002-中国工商银行股份有限公司田阳县支行");
        newNameMap.put("02003","02003-中国工商银行股份有限公司田东县支行");
        newNameMap.put("02004","02004-中国工商银行股份有限公司平果县支行");
        newNameMap.put("02005","02005-工行德保支行");
        newNameMap.put("02006","02006-中国工商银行股份有限公司靖西市支行");
        newNameMap.put("02007","02007-工行那坡支行");
        newNameMap.put("02008","02008-工行市区支行");
        newNameMap.put("02009","02009-工行凌云支行");
        newNameMap.put("02010","02010-中国工商银行股份有限公司隆林县支行");
        newNameMap.put("02011","02011-中国工商银行股份有限公司田林县支行");
        newNameMap.put("03001","03001-中国农业银行百色市右江支行");
        newNameMap.put("03002","03002-中国农业银行股份有限公司田阳县支行");
        newNameMap.put("03003","03003-中国农业银行股份有限公司田东县支行");
        newNameMap.put("03004","03004-农行平果支行");
        newNameMap.put("03005","03005-中国农行银行股份有限公司德保县支行");
        newNameMap.put("03006","03006-中国农业银行股份有限公司靖西市支行");
        newNameMap.put("03007","03007-中国农行银行股份有限公司那坡县支行");
        newNameMap.put("03008","03008-农行市区支行");
        newNameMap.put("03009","03009-中国农业银行股份有限公司凌云县支行");
        newNameMap.put("03010","03010-中国农业银行股份有限公司田林县支行");
        newNameMap.put("03011","03011-中国农业银行股份有限公司乐业县支行");
        newNameMap.put("03012","03012-中国农业银行股份有限公司隆林各族自治县支行");
        newNameMap.put("03013","03013-中国农业银行股份有限公司西林县支行");
        newNameMap.put("04001","04001-中行右江支行");
        newNameMap.put("04002","04002-中行田阳支行");
        newNameMap.put("04003","04003-中行田东支行");
        newNameMap.put("04004","04004-中国银行股份有限公司平果支行");
        newNameMap.put("04005","04005-中行德保支行");
        newNameMap.put("04006","04006-中行靖西支行");
        newNameMap.put("04007","04007-中行那坡支行");
        newNameMap.put("04008","04008-中国银行百色市分行");
        newNameMap.put("04009","04009-中行凌云支行");
        newNameMap.put("04010","04010-中行平果铝支行");
        newNameMap.put("05001","05001-交通银行百色分行营业部");
        newNameMap.put("05002","05002-交通银行右江支行");
        newNameMap.put("05003","05003-交通银行田阳支行");
        newNameMap.put("25001","25001-广西百色市右江农村合作银行");
        newNameMap.put("25002","25002-农信田阳支行");
        newNameMap.put("25003","25003-广西田东农村商业银行股份有限公司");
        newNameMap.put("25004","25004-农信平果支行");
        newNameMap.put("25005","25005-农信德保支行");
        newNameMap.put("25006","25006-广西靖西农村商业银行股份有限公司");
        newNameMap.put("25007","25007-农信那坡支行");
        newNameMap.put("25008","25008-农信市区支行");
        newNameMap.put("25009","25009-农信凌云支行");
        newNameMap.put("25010","25010-农信平果铝支行");
        newNameMap.put("25011","25011-田林县农村信用合作联社营业部");
        newNameMap.put("25012","25012-农信隆林支行");
        newNameMap.put("25013","25013-农信西林支行");
        newNameMap.put("25014","25014-农信乐业支行");
        newNameMap.put("31001","31001-柳州银行股份有限公司百色分行");
        newNameMap.put("32001","32001-北部湾市区支行");
        newNameMap.put("00","中心市本部");
        newNameMap.put("01","右江管理部");
        newNameMap.put("02","田阳管理部");
        newNameMap.put("03","田东管理部");
        newNameMap.put("04","平果管理部");
        newNameMap.put("05","德保管理部");
        newNameMap.put("06","靖西管理部");
        newNameMap.put("07","那坡管理部");
        newNameMap.put("08","凌云管理部");
        newNameMap.put("09","乐业管理部");
        newNameMap.put("10","田林管理部");
        newNameMap.put("11","隆林管理部");
        newNameMap.put("12","西林管理部");
        newNameMap.put("13","平果铝管理部");

    }
}
