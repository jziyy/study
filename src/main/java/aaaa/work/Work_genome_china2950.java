package aaaa.work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import aaaa.template.Template_one;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Function;



/**
 北京金诺美生物技术有限公司1


 */

public class Work_genome_china2950 {

	public static void main(String[] args) {
		/**url处理方法*/

		String Fsearchurl = "http://www.genome-china.com/product/5/";

		/**网站名称*/
		String company = "北京金诺美生物技术有限公司";

		/**获取所有标签*/
		Function<Document, Elements> FMain = (e) ->e.getElementsByAttributeValue("class","e_box e_box-000 p_products").get(0).
				getElementsByAttributeValue("class","e_box e_ProductBox-001 p_Product");

		/**获取图片url*/
		Function<Element,String> FimgUrl = (e) ->{String json = e.getElementsByAttributeValue("class","e_box e_box-000 p_images")
				.get(0).attr("imgData");
			JSONObject jsonObject = JSON.parseObject(json);
			JSONArray jsonArray =jsonObject.getJSONArray("navs");
			JSONObject jsonObject1 = jsonArray.getJSONObject(0);
			String srcBigPic = jsonObject1.getString("srcBigPic");
			return "http://www.genome-china.com/" + srcBigPic;

		};

		/**获取商品名称*/
		Function<Element,String> FgoodName  = (e) -> e.getElementsByAttributeValue("class","e_title e_ImgTitle-001 d_title p_title_1 js-protitle")
				.get(0).select("div").text();

		/**获取商品地址    http://www.glory-way.com/*/
		Function<Element,String> FgoodUrl  = (e) -> "http://www.genome-china.com" + e.getElementsByAttributeValue("class","e_title e_ImgTitle-001 d_title p_title_1 js-protitle")
				.get(0).attr("data-url");

		Template_one.pcTemplate(Fsearchurl,FMain,FimgUrl,FgoodName,FgoodUrl,company);
	}


}