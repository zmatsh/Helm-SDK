package io.winhong.pass.grpc.client;

import com.google.protobuf.ByteString;

import io.winhong.pass.hapi.chart.ChartOuterClass;
import io.winhong.pass.hapi.chart.MetadataOuterClass;
import io.winhong.pass.hapi.chart.TemplateOuterClass;
import io.winhong.pass.hapi.services.Tiller;

public class HelmDependent {

	
	public ChartOuterClass.Chart getADependent(){
		
		  MetadataOuterClass.Metadata metadata = MetadataOuterClass.Metadata.newBuilder()
	        		.setApiVersion("V1")
	        		.setDescription("tiger test by helm sdk dependent")
	        		.setName("tomcat")
	        		.setVersion("8")
	        		.build();
	        
	        ByteString byteString = ByteString.copyFromUtf8(
	        		"apiVersion: extensions/v1beta1 \n"
	        	  + "kind: Deployment\n"
	        	  + "metadata:\n"
	        	  + "  name: {{ template \"fullname\" . }}\n"
	        	  + "  labels:\n"
	        	  + "    chart: \"{{ .Chart.Name }}-{{ .Chart.Version | replace \"+\" \"_\" }}\"\n"
	        	  + "spec:\n"
	        	  + "  replicas: {{ .Values.replicaCount }}\n"
	        	  + "  template:\n"
	        	  + "    metadata:\n"
	        	  + "      labels:\n"
	        	  + "        app: {{ template \"fullname\" . }}\n"
	        	  + "    spec:\n"
	        	  + "      containers:\n"
	        	  + "      - name: {{ .Chart.Name }}\n"
	        	  + "        image: \"{{ .Values.image }}:{{ .Values.tag }}\"\n"
	        	  + "        imagePullPolicy: {{ .Values.image.pullPolicy }}\n"
	        	  + "        ports:\n"
	        	  + "        - containerPort: {{ .Values.service.internalPort }}\n");
	        
	        TemplateOuterClass.Template template = TemplateOuterClass.Template.newBuilder()
	        		.setName("templates/deployment.yaml")
	        		.setData(byteString)
	        		.build();
	       
	        
	        ByteString byteString2 = ByteString.copyFromUtf8("{{/* vim: set filetype=mustache: */}}\n{{/*\nExpand the name of the chart.\n*/}}\n{{- define \"name\" -}}\n{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix \"-\" -}}\n{{- end -}}\n\n{{/*\nCreate a default fully qualified app name.\nWe truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).\n*/}}\n{{- define \"fullname\" -}}\n{{- $name := default .Chart.Name .Values.nameOverride -}}\n{{- printf \"%s-%s\" .Release.Name $name | trunc 63 | trimSuffix \"-\" -}}\n{{- end -}}\n");
	        TemplateOuterClass.Template template2 = TemplateOuterClass.Template.newBuilder()
	        		.setName("templates/_helpers.tpl")
	        		.setData(byteString2)
	        		.build();
	        
	        ByteString byteString3 = ByteString.copyFromUtf8(
	        		"oapiVersion: v1\n"
	        	  + "kind: Service\n"
	        	  + "metadata:\n"
	        	  + "  name: {{ template \"fullname\" . }}\n"
	        	  + "  labels:\n"
	        	  + "    chart: \"{{ .Chart.Name }}-{{ .Chart.Version | replace \"+\" \"_\" }}\"\n"
	        	  + "spec:\n"
	        	  + "  type: {{ .Values.service.type }}\n"
	        	  + "  ports:\n"
	        	  + "  - port: {{ .Values.service.externalPort }}\n"
	        	  + "    targetPort: {{ .Values.service.internalPort }}\n"
	        	  + "    nodePort: {{ .Values.service.nodePort }}\n"
	        	  + "    protocol: TCP\n"
	        	  + "    name: {{ .Values.service.name }}\n"
	        	  + "  selector:\n"
	        	  + "    app: {{ template \"fullname\" . }}\n");
	        
	        TemplateOuterClass.Template template3 = TemplateOuterClass.Template.newBuilder()
	        		.setName("templates/service.yaml")
	        		.setData(byteString3)
	        		.build();
		
	        ChartOuterClass.Chart cc = ChartOuterClass.Chart.newBuilder()
	        		/*.setValues(config)*/
	        		.setMetadata(metadata)
	        		.addTemplates(template)
	        		.addTemplates(template2)
	        		.addTemplates(template3)
	        		.build();
		
		return cc;
	}

}
