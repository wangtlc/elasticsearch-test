package com.索引创建;

import java.net.InetAddress;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.google.gson.Gson; 

public class ElasticSearchHandler {
	public static void main(String[] args) {
		try {
			// 设置cluster_name
			Settings settings = Settings.EMPTY.settingsBuilder().put("cluster.name", "my-application").build();
			Client client = TransportClient.builder().settings(settings).build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("wangtlc1"), 9300));

			Gson gson = new Gson();
			String gsonStr = gson.toJson(new Blog(1, "git简介", "2016-06-19", "SVN与Git最主要的区别..."));
			IndexResponse response = client.prepareIndex("blog", "article").setSource(gsonStr).get();
			if (response.isCreated()) {
				System.out.println("创建成功!");
			}
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}