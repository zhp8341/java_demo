package json;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2021/8/19
 * @time 10:11
 */
public class JsonMain {

  public static void main(String[] args){

      String s="{\"job_parameters\":{\"job_type\":\"train\",\"model_version\":\"20210811204751496100\",\"jd_id\":702,\"count\":1,\"computing_engine\":\"EGGROLL\",\"model_id\":\"host-10005#guest-10002#model\",\"task_parallelism\":1,\"rabbitmq_run\":{},\"work_mode\":1,\"federation_engine\":\"EGGROLL\",\"module_id\":116,\"engines_address\":{},\"federated_status_collect_type\":\"PUSH\",\"project_id\":11,\"backend\":0,\"storage_engine\":\"EGGROLL\",\"eggroll_run\":{\"eggroll.session.processors.per.node\":8},\"adaptation_parameters\":{\"task_nodes\":8,\"task_cores_per_node\":8,\"task_memory_per_node\":0},\"spark_run\":{},\"federated_mode\":\"MULTIPLE\"},\"dsl_version\":1,\"role_parameters\":{\"host\":{\"args\":{\"data\":{\"raw_data\":[{\"name\":\"10005_host_1628686071314_6006\",\"namespace\":\"10005_1628686071314_6006\"}]}},\"datalink_0\":{\"partition\":[8],\"missing_impute\":[[\"null\",\"None\",\"NULL\",\"N/A\"]],\"intersect_id\":[[\"id\"]],\"impute_default\":[\"NaN\"],\"namespace\":[\"10005_1628686071314_6006\"],\"id\":[4],\"table_name\":[\"10005_host_1628686071314_6006\"],\"cols_sort_dict\":[{\"postp\":[\"C0\",\"C1\",\"C2\",\"C3\",\"NaN\",\"C3444\",\"C4\",\"C5\",\"C6\"]}],\"custom_cols_missing_impute\":[{\"albbal\":\"199, 492\",\"nd0512\":\"6\",\"telyn\":\"\",\"cmpc\":\"C2\",\"pyv7l06\":\"\",\"pybtl18\":\"\",\"pybtl12\":\"\",\"pyv7l12\":\"\",\"postp\":\"\",\"lec10p\":\"\"}],\"cols_type_dict\":[{\"albbal\":\"Numerical\",\"nd0512\":\"Discrete\",\"telyn\":\"Nominal\",\"cmpc\":\"Nominal\",\"pyv7l06\":\"Numerical\",\"Nick\":\"Other\",\"pybtl18\":\"Numerical\",\"id\":\"Key\",\"pybtl12\":\"Numerical\",\"pyv7l12\":\"Numerical\",\"postp\":\"Ordinal\",\"lec10p\":\"Numerical\"}]}},\"guest\":{\"args\":{\"data\":{\"raw_data\":[{\"name\":\"10002_guest_1628686071314_6006\",\"namespace\":\"10002_1628686071314_6006\"}]}},\"datalink_0\":{\"partition\":[8],\"missing_impute\":[[\"null\",\"None\",\"NULL\",\"N/A\"]],\"intersect_id\":[[\"id\"]],\"impute_default\":[\"NaN\"],\"namespace\":[\"10002_1628686071314_6006\"],\"id\":[706],\"table_name\":[\"10002_guest_1628686071314_6006\"],\"cols_sort_dict\":[{\"rsdc\":[\"C4\",\"C9\",\"C6\",\"C5\",\"C1\",\"C8\",\"C7\",\"NaN\",\"C2\",\"101010\"],\"lebsi\":[\"C00\",\"C74\",\"NaN\",\"C72\",\"CM\",\"C99\"]}],\"custom_cols_missing_impute\":[{\"lec10a\":\"\",\"balic_c\":\"\",\"cardtp\":\"C102\",\"cbc\":\"\",\"rsdc\":\"C3\",\"lec04n\":\"\",\"lec10n\":\"5\",\"lebsi\":\"\",\"lecpd\":\"\"}],\"cols_type_dict\":[{\"lec10a\":\"Numerical\",\"balic_c\":\"Numerical\",\"cardtp\":\"Nominal\",\"bad\":\"Y\",\"cbc\":\"Numerical\",\"rsdc\":\"Ordinal\",\"name\":\"Key\",\"lec04n\":\"Discrete\",\"id\":\"Key\",\"lec10n\":\"Numerical\",\"lebsi\":\"Ordinal\",\"lecpd\":\"Numerical\"}]}}},\"role\":{\"host\":[10005],\"guest\":[10002]},\"workMode\":1,\"initiator\":{\"role\":\"guest\",\"party_id\":10002},\"algorithm_parameters\":{},\"jobParameter\":{\"job_type\":\"train\",\"model_version\":\"20210811204751496100\",\"jd_id\":702,\"count\":1,\"computing_engine\":\"EGGROLL\",\"model_id\":\"host-10005#guest-10002#model\",\"task_parallelism\":1,\"rabbitmq_run\":{},\"work_mode\":1,\"federation_engine\":\"EGGROLL\",\"module_id\":116,\"engines_address\":{},\"federated_status_collect_type\":\"PUSH\",\"project_id\":11,\"backend\":0,\"storage_engine\":\"EGGROLL\",\"eggroll_run\":{\"eggroll.session.processors.per.node\":8},\"adaptation_parameters\":{\"task_nodes\":8,\"task_cores_per_node\":8,\"task_memory_per_node\":0},\"spark_run\":{},\"federated_mode\":\"MULTIPLE\"},\"jobType\":\"train\"}";

     Map<String,Object> json= JSON.parseObject(s);
     System.out.println(json);


  }

}
