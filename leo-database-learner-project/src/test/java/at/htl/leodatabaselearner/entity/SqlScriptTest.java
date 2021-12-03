//package at.htl.leodatabaselearner.entity;
//
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//class SqlScriptTest {
//    @Test
//    void testToString() {
//        Teacher teacher = new Teacher("Max", "Muster","pass234");
//        DataModel dataModel = new DataModel("DataModel1", teacher, "Comment1");
//        SqlScript sqlScript = new SqlScript(dataModel, "createScript1", "dropScript1", "insertScript1");
//        String testString = sqlScript.toString();
//        String rightString = "Das SqlScript hat die" +
//                " id " + sqlScript.getId() +
//                " das createScript '" + sqlScript.createScript + '\'' +
//                " das dropScript '" + sqlScript.dropScript + '\'' +
//                " und das insertScript '" + sqlScript.insertScript + '\'' +
//                '.';
//
//        assertThat(testString).isEqualTo(rightString);
//    }
//}
