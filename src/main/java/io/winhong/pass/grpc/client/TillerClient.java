package io.winhong.pass.grpc.client;

import io.winhong.pass.hapi.chart.ChartOuterClass;
import io.winhong.pass.hapi.chart.ChartOuterClass.ChartOrBuilder;
import io.winhong.pass.hapi.chart.ConfigOuterClass;
import io.winhong.pass.hapi.chart.MetadataOuterClass;
import io.winhong.pass.hapi.chart.TemplateOuterClass;
import io.winhong.pass.hapi.services.ReleaseServiceGrpc;
import io.winhong.pass.hapi.services.Tiller;
import io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest;
import io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest.Builder;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.ByteString;

public class TillerClient {
	
	public static void deployAChart(ReleaseServiceGrpc.ReleaseServiceBlockingStub blockingStub){

        MetadataOuterClass.Metadata metadata = MetadataOuterClass.Metadata.newBuilder()
        		.setApiVersion("V1")
        		.setDescription("tiger test by helm sdk")
        		.setName("mysql-test")
        		.setVersion("0.1.2")
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
        	  + "        image: \"172.16.101.192/common/mysql:5.6\"\n"
        	  + "        imagePullPolicy: {{ .Values.image.pullPolicy }}\n"
        	  + "        ports:\n"
        	  + "        - containerPort: {{ .Values.service.internalPort }}\n"
        	  + "        env:\n"
        	  + "         - name: MYSQL_ROOT_PASSWORD\n"
        	  + "           value: root\n");
        
        TemplateOuterClass.Template template = TemplateOuterClass.Template.newBuilder()
        		.setName("templates/deployment.yaml")
        		.setData(byteString)
        		.build();
        
        ByteString byteString2 = ByteString.copyFromUtf8("{{/* vim: set filetype=mustache: */}}\n{{/*\nExpand the name of the chart.\n*/}}\n{{- define \"name\" -}}\n{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix \"-\" -}}\n{{- end -}}\n\n{{/*\nCreate a default fully qualified app name.\nWe truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).\n*/}}\n{{- define \"fullname\" -}}\n{{- $name := default .Chart.Name .Values.nameOverride -}}\n{{- printf \"%s-%s\" .Release.Name $name | trunc 63 | trimSuffix \"-\" -}}\n{{- end -}}\n");
        TemplateOuterClass.Template template2 = TemplateOuterClass.Template.newBuilder()
        		.setName("templates/_helpers.tpl")
        		.setData(byteString2)
        		.build();
        
        ByteString byteString3 = ByteString.copyFromUtf8("oapiVersion: v1\nkind: Service\nmetadata:\n  name: {{ template \"fullname\" . }}\n  labels:\n    chart: \"{{ .Chart.Name }}-{{ .Chart.Version | replace \"+\" \"_\" }}\"\nspec:\n  type: {{ .Values.service.type }}\n  ports:\n  - port: {{ .Values.service.externalPort }}\n    targetPort: {{ .Values.service.internalPort }}\n    nodePort: {{ .Values.service.nodePort }}\n    protocol: TCP\n    name: {{ .Values.service.name }}\n  selector:\n    app: {{ template \"fullname\" . }}\n");
        TemplateOuterClass.Template template3 = TemplateOuterClass.Template.newBuilder()
        		.setName("templates/service.yaml")
        		.setData(byteString3)
        		.build();
        ByteString byteString4 = ByteString.copyFromUtf8("# Default values for mysql1. \n"
  			  + "# This is a YAML-formatted file. \n"
  			  + "# Declare variables to be passed into your templates. \n"
  			  + "replicaCount: 1 \n"
  			  + "image: \n"
  			  + "  repository: 172.16.101.192/common/mysql \n"
  			  + "  tag: 5.6 \n"
  			  + "  pullPolicy: IfNotPresent \n"
  			  + "service: \n"
  			  + "  name: mysql \n"
  			  + "  type: NodePort \n"
  			  + "  externalPort: 80 \n"
  			  + "  internalPort: 80 \n"
  			  + "  nodePort: 30088 \n"
  			  + "resources: \n"
  			  + "  limits: \n"
  			  + "    cpu: 100m \n"
  			  + "    memory: 128Mi \n"
  			  + "  requests: \n"
  			  + "    cpu: 100m \n"
  			  + "    memory: 128Mi \n"
  			  + "tomcat_image_1: 172.16.101.192/common/tomcat\n"
  			  + "tomcat:\n"
			  + " image: 172.16.101.192/common/tomcat\n"
			  + " tag: 8\n"
			  + " service:\n"
			  + "  name: tomcat\n"
			  + "  externalPort: 8080 \n"
			  + "  internalPort: 8080 \n"
			  + "  nodePort: 30006\n"
			  
  			  );
        ConfigOuterClass.Config config = ConfigOuterClass.Config.newBuilder()
        		.setRawBytes(byteString4)
        		.build();
        System.out.println("values====>"+config.getRaw());
        ChartOuterClass.Chart cc = ChartOuterClass.Chart.newBuilder()
        		/*.setValues(config)*/
        		.setMetadata(metadata)
        		/*.addDependencies(new HelmDependent().getADependent())*/
        		.addTemplates(template)
        		.addTemplates(template2)
        		.addTemplates(template3)
        		.build();
        
        Tiller.InstallReleaseRequest iReleaseRequest = Tiller.InstallReleaseRequest.newBuilder()
        		/*release name*/
        		.setName("tiger-test")
        		
        		.setNamespace("tiger")
        		.setValues(config)
        		.setChart(cc)
        		.build();
        Tiller.InstallReleaseResponse releaseStatusResponse = blockingStub.installRelease(iReleaseRequest);
        for(int i = 0 ; i < releaseStatusResponse.findInitializationErrors().size() ; i++ ){
        	 
             System.out.println(""+releaseStatusResponse.findInitializationErrors().get(i).toString());
        }
	}

	
	public static void updateDeploy(ReleaseServiceGrpc.ReleaseServiceBlockingStub blockingStub){
		
		ConfigOuterClass.Config config = ConfigOuterClass.Config.newBuilder()
        		/*.setRawBytes(byteString4)*/
        		.setRaw(
        				"# Default values for mysql1.\n"
        			  + "# This is a YAML-formatted file.\n"
        			  + "# Declare variables to be passed into your templates.\n"
        			  + "replicaCount: 1\n"
        			  + "image:\n"
        			  + "  repository: 172.16.101.192/common/mysql\n"
        			  + "  tag: 5.6\n"
        			  + "  pullPolicy: IfNotPresent\n"
        			  + "service:\n"
        			  + "  name: mysql\n"
        			  + "  type: NodePort\n"
        			  + "  externalPort: 80\n"
        			  + "  internalPort: 80\n"
        			  + "  nodePort: 30088\n"
        			  + "resources:\n"
        			  + "  limits:\n"
        			  + "    cpu: 100m\n"
        			  + "    memory: 129Mi\n"
        			  + "  requests:\n"
        			  + "    cpu: 100m\n"
        			  + "    memory: 129Mi\n"
        			  + "\n")
        		.build();
		
		  MetadataOuterClass.Metadata metadata = MetadataOuterClass.Metadata.newBuilder()
	        		.setApiVersion("V1")
	        		.setDescription("tiger test by helm sdk")
	        		.setName("mysql-test")
	        		.setVersion("0.1.2")
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
	        	  + "        image: \"172.16.101.192/common/mysql:5.6\"\n"
	        	  + "        imagePullPolicy: {{ .Values.image.pullPolicy }}\n"
	        	  + "        ports:\n"
	        	  + "        - containerPort: {{ .Values.service.internalPort }}\n"
	        	  + "        env:\n"
	        	  + "         - name: MYSQL_ROOT_PASSWORD\n"
	        	  + "           value: root\n");
	        
	        TemplateOuterClass.Template template = TemplateOuterClass.Template.newBuilder()
	        		.setName("templates/deployment.yaml")
	        		.setData(byteString)
	        		.build();
	        
	        ByteString byteString2 = ByteString.copyFromUtf8("{{/* vim: set filetype=mustache: */}}\n{{/*\nExpand the name of the chart.\n*/}}\n{{- define \"name\" -}}\n{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix \"-\" -}}\n{{- end -}}\n\n{{/*\nCreate a default fully qualified app name.\nWe truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).\n*/}}\n{{- define \"fullname\" -}}\n{{- $name := default .Chart.Name .Values.nameOverride -}}\n{{- printf \"%s-%s\" .Release.Name $name | trunc 63 | trimSuffix \"-\" -}}\n{{- end -}}\n");
	        TemplateOuterClass.Template template2 = TemplateOuterClass.Template.newBuilder()
	        		.setName("templates/_helpers.tpl")
	        		.setData(byteString2)
	        		.build();
	        
	        ByteString byteString3 = ByteString.copyFromUtf8("oapiVersion: v1\nkind: Service\nmetadata:\n  name: {{ template \"fullname\" . }}\n  labels:\n    chart: \"{{ .Chart.Name }}-{{ .Chart.Version | replace \"+\" \"_\" }}\"\nspec:\n  type: {{ .Values.service.type }}\n  ports:\n  - port: {{ .Values.service.externalPort }}\n    targetPort: {{ .Values.service.internalPort }}\n    nodePort: {{ .Values.service.nodePort }}\n    protocol: TCP\n    name: {{ .Values.service.name }}\n  selector:\n    app: {{ template \"fullname\" . }}\n");
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
		Tiller.UpdateReleaseRequest updateReleaseRequest =  Tiller.UpdateReleaseRequest.newBuilder().setName("tiger-test").setValues(config).setChart(cc).build();
		Tiller.UpdateReleaseResponse rp = blockingStub.updateRelease(updateReleaseRequest);
		for(int i = 0 ; i < rp.findInitializationErrors().size() ; i++ ){
        	 
             System.out.println(""+rp.findInitializationErrors().get(i).toString());
        }
	}
	//TODO
	public static void undeploy(ReleaseServiceGrpc.ReleaseServiceBlockingStub blockingStub){
		Tiller.UninstallReleaseRequest uninstallReleaseRequest = Tiller.UninstallReleaseRequest.newBuilder()
				.setName("tiger-test")
				.setPurge(true)
				.build();
		blockingStub.uninstallRelease(uninstallReleaseRequest);
	}
	
    public static void main(String[] args) throws InterruptedException {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("172.16.101.200", 44134).usePlaintext(true).build();

        ManagedChannel channel = NettyChannelBuilder
                .forAddress("172.16.101.200", 44134)
                .negotiationType(NegotiationType.PLAINTEXT).build();

        ReleaseServiceGrpc.ReleaseServiceBlockingStub blockingStub = ReleaseServiceGrpc
                .newBlockingStub(channel).withCallCredentials(new CallCredentials(){

					@Override
					public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs,
							Executor appExecutor, MetadataApplier applier) {
						// TODO Auto-generated method stub
						  Metadata metadata = new Metadata();
		                  metadata.put(Metadata.Key.of("x-helm-api-client", Metadata.ASCII_STRING_MARSHALLER), "v2.2.0");
		                  applier.apply(metadata);
					}
                	
                });
       

        deployAChart(blockingStub);
        //updateDeploy(blockingStub);
        //undeploy(blockingStub);
       /* Tiller.GetVersionResponse response = blockingStub.getVersion(Tiller.GetVersionRequest.newBuilder().build());
        System.out.println(response.getVersion());

        Iterator<Tiller.ListReleasesResponse> listReleasesIterator = blockingStub.listReleases(Tiller.ListReleasesRequest.newBuilder().build());
        System.out.println("================start=================");
        while (listReleasesIterator.hasNext()) {
            System.out.println(listReleasesIterator.next());
            System.out.println("---------------------------------");
        }
        System.out.println("================end=================");
        
        Tiller.GetReleaseStatusResponse releaseStatus = blockingStub.getReleaseStatus(Tiller.GetReleaseStatusRequest
                .newBuilder()
                .setName("invited-catfish").build());
        System.out.println("status:"+releaseStatus);

        System.out.println("-----------------");
        
        Tiller.GetHistoryResponse history = blockingStub.getHistory(Tiller.GetHistoryRequest.newBuilder()
                .setName("invited-catfish").setMax(10).build());
        System.out.println(history);
*/
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
