package io.winhong.pass.grpc.client;

import io.grpc.*;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import io.grpc.*;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import io.winhong.pass.hapi.services.ReleaseServiceGrpc;
import io.winhong.pass.hapi.services.Tiller;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangjianxin on 2017/4/7.
 */
public class entrypoint {

    public static void main(String[] args) throws InterruptedException {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("172.16.101.200", 44134).usePlaintext(true).build();

        ManagedChannel channel = NettyChannelBuilder
                .forAddress("172.16.80.151", 44134)
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

        //deployAChart(blockingStub);
        //updateDeploy(blockingStub);
        //undeploy(blockingStub);
        Tiller.GetVersionResponse response = blockingStub.getVersion(Tiller.GetVersionRequest.newBuilder().build());
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

        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}