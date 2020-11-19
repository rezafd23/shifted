package day9.practice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.JSONValue;

public class JsonExample1 {
    public static void main(String[] args) {



        JSONObject obj = new JSONObject();
        obj.put("name","sonoo");
        obj.put("age",27);
        obj.put("salary",60000);
        JSONObject obj2 = new JSONObject();
        obj2.put("name","sonoo F");
        obj2.put("age",30);
        obj2.put("salary",50000);
        JSONObject obj3 = new JSONObject();
        obj3.put("name","sonoo G");
        obj3.put("age",19);
        obj3.put("salary",100000);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(obj);
        jsonArray.add(obj2);
        jsonArray.add(obj3);

        JSONObject emp = new JSONObject();
        emp.put("Employee",jsonArray);

//        JSONObject outerObject = new JSONObject(jsonInput);
//        JSONObject innerObject = outerObject.getJSONObject("JObjects");
//        JSONArray jsonArray = innerObject.getJSONArray("JArray1");
        JSONObject empObj = new JSONObject(emp);
        JSONArray elem = (JSONArray) empObj.get("Employee");

//        JSONArray elem = emp.getJSON;
        System.out.println("elem: "+elem);

        for (int i=0;i<elem.size();i++){
           JSONObject objTemp = (JSONObject) elem.get(i);
           String name = (String) objTemp.get("name");
           Integer age = (Integer) objTemp.get("age");
           Integer salary = (Integer) objTemp.get("salary");
            System.out.println("NAME: "+ name);
            System.out.println("AGE: "+ age);
            System.out.println("Salary: "+ salary);
        }
//        for (int i=0;i<emp.get("Employee").l;)

//        String s="{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}";
//        Object obj= JSONValue.parse(s);
//        JSONObject jsonObject = (JSONObject) obj;
//        String name = (String) jsonObject.get("name");
//        double salary = (Double) jsonObject.get("salary");
//        long age = (Long) jsonObject.get("age");
//        System.out.println(name+" "+salary+" "+age);

    }
}
