package io.winhong.pass.hapi.services;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * ReleaseService is the service that a helm application uses to mutate,
 * query, and manage releases.
 *		Release: A named installation composed of a chart and
 * 				 config. At any given time a release has one
 *				 chart and one config.
 *		Config:  A config is a YAML file that supplies values
 *				 to the parametrizable templates of a chart.
 *		Chart:   A chart is a helm package that contains
 *				 metadata, a default config, zero or more
 *				 optionally parameterizable templates, and
 *				 zero or more charts (dependencies).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.3)",
    comments = "Source: hapi/services/tiller.proto")
public class ReleaseServiceGrpc {

  private ReleaseServiceGrpc() {}

  public static final String SERVICE_NAME = "hapi.services.tiller.ReleaseService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.ListReleasesRequest,
      io.winhong.pass.hapi.services.Tiller.ListReleasesResponse> METHOD_LIST_RELEASES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "ListReleases"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.ListReleasesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.ListReleasesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest,
      io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse> METHOD_GET_RELEASE_STATUS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "GetReleaseStatus"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest,
      io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse> METHOD_GET_RELEASE_CONTENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "GetReleaseContent"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest,
      io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse> METHOD_UPDATE_RELEASE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "UpdateRelease"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest,
      io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse> METHOD_INSTALL_RELEASE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "InstallRelease"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest,
      io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse> METHOD_UNINSTALL_RELEASE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "UninstallRelease"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.GetVersionRequest,
      io.winhong.pass.hapi.services.Tiller.GetVersionResponse> METHOD_GET_VERSION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "GetVersion"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetVersionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetVersionResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest,
      io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse> METHOD_ROLLBACK_RELEASE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "RollbackRelease"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.GetHistoryRequest,
      io.winhong.pass.hapi.services.Tiller.GetHistoryResponse> METHOD_GET_HISTORY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "GetHistory"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetHistoryRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.GetHistoryResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.winhong.pass.hapi.services.Tiller.TestReleaseRequest,
      io.winhong.pass.hapi.services.Tiller.TestReleaseResponse> METHOD_RUN_RELEASE_TEST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "hapi.services.tiller.ReleaseService", "RunReleaseTest"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.TestReleaseRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.winhong.pass.hapi.services.Tiller.TestReleaseResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReleaseServiceStub newStub(io.grpc.Channel channel) {
    return new ReleaseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReleaseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReleaseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ReleaseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReleaseServiceFutureStub(channel);
  }

  /**
   * <pre>
   * ReleaseService is the service that a helm application uses to mutate,
   * query, and manage releases.
   *		Release: A named installation composed of a chart and
   * 				 config. At any given time a release has one
   *				 chart and one config.
   *		Config:  A config is a YAML file that supplies values
   *				 to the parametrizable templates of a chart.
   *		Chart:   A chart is a helm package that contains
   *				 metadata, a default config, zero or more
   *				 optionally parameterizable templates, and
   *				 zero or more charts (dependencies).
   * </pre>
   */
  public static abstract class ReleaseServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * ListReleases retrieves release history.
     * TODO: Allow filtering the set of releases by
     * release status. By default, ListAllReleases returns the releases who
     * current status is "Active".
     * </pre>
     */
    public void listReleases(io.winhong.pass.hapi.services.Tiller.ListReleasesRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.ListReleasesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_RELEASES, responseObserver);
    }

    /**
     * <pre>
     * GetReleasesStatus retrieves status information for the specified release.
     * </pre>
     */
    public void getReleaseStatus(io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_RELEASE_STATUS, responseObserver);
    }

    /**
     * <pre>
     * GetReleaseContent retrieves the release content (chart + value) for the specified release.
     * </pre>
     */
    public void getReleaseContent(io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_RELEASE_CONTENT, responseObserver);
    }

    /**
     * <pre>
     * UpdateRelease updates release content.
     * </pre>
     */
    public void updateRelease(io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_RELEASE, responseObserver);
    }

    /**
     * <pre>
     * InstallRelease requests installation of a chart as a new release.
     * </pre>
     */
    public void installRelease(io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INSTALL_RELEASE, responseObserver);
    }

    /**
     * <pre>
     * UninstallRelease requests deletion of a named release.
     * </pre>
     */
    public void uninstallRelease(io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNINSTALL_RELEASE, responseObserver);
    }

    /**
     * <pre>
     * GetVersion returns the current version of the server.
     * </pre>
     */
    public void getVersion(io.winhong.pass.hapi.services.Tiller.GetVersionRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetVersionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_VERSION, responseObserver);
    }

    /**
     * <pre>
     * RollbackRelease rolls back a release to a previous version.
     * </pre>
     */
    public void rollbackRelease(io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLLBACK_RELEASE, responseObserver);
    }

    /**
     * <pre>
     * ReleaseHistory retrieves a releasse's history.
     * </pre>
     */
    public void getHistory(io.winhong.pass.hapi.services.Tiller.GetHistoryRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetHistoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HISTORY, responseObserver);
    }

    /**
     * <pre>
     * RunReleaseTest executes the tests defined of a named release
     * </pre>
     */
    public void runReleaseTest(io.winhong.pass.hapi.services.Tiller.TestReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.TestReleaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RUN_RELEASE_TEST, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LIST_RELEASES,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.ListReleasesRequest,
                io.winhong.pass.hapi.services.Tiller.ListReleasesResponse>(
                  this, METHODID_LIST_RELEASES)))
          .addMethod(
            METHOD_GET_RELEASE_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest,
                io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse>(
                  this, METHODID_GET_RELEASE_STATUS)))
          .addMethod(
            METHOD_GET_RELEASE_CONTENT,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest,
                io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse>(
                  this, METHODID_GET_RELEASE_CONTENT)))
          .addMethod(
            METHOD_UPDATE_RELEASE,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest,
                io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse>(
                  this, METHODID_UPDATE_RELEASE)))
          .addMethod(
            METHOD_INSTALL_RELEASE,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest,
                io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse>(
                  this, METHODID_INSTALL_RELEASE)))
          .addMethod(
            METHOD_UNINSTALL_RELEASE,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest,
                io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse>(
                  this, METHODID_UNINSTALL_RELEASE)))
          .addMethod(
            METHOD_GET_VERSION,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.GetVersionRequest,
                io.winhong.pass.hapi.services.Tiller.GetVersionResponse>(
                  this, METHODID_GET_VERSION)))
          .addMethod(
            METHOD_ROLLBACK_RELEASE,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest,
                io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse>(
                  this, METHODID_ROLLBACK_RELEASE)))
          .addMethod(
            METHOD_GET_HISTORY,
            asyncUnaryCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.GetHistoryRequest,
                io.winhong.pass.hapi.services.Tiller.GetHistoryResponse>(
                  this, METHODID_GET_HISTORY)))
          .addMethod(
            METHOD_RUN_RELEASE_TEST,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.winhong.pass.hapi.services.Tiller.TestReleaseRequest,
                io.winhong.pass.hapi.services.Tiller.TestReleaseResponse>(
                  this, METHODID_RUN_RELEASE_TEST)))
          .build();
    }
  }

  /**
   * <pre>
   * ReleaseService is the service that a helm application uses to mutate,
   * query, and manage releases.
   *		Release: A named installation composed of a chart and
   * 				 config. At any given time a release has one
   *				 chart and one config.
   *		Config:  A config is a YAML file that supplies values
   *				 to the parametrizable templates of a chart.
   *		Chart:   A chart is a helm package that contains
   *				 metadata, a default config, zero or more
   *				 optionally parameterizable templates, and
   *				 zero or more charts (dependencies).
   * </pre>
   */
  public static final class ReleaseServiceStub extends io.grpc.stub.AbstractStub<ReleaseServiceStub> {
    private ReleaseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReleaseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReleaseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReleaseServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * ListReleases retrieves release history.
     * TODO: Allow filtering the set of releases by
     * release status. By default, ListAllReleases returns the releases who
     * current status is "Active".
     * </pre>
     */
    public void listReleases(io.winhong.pass.hapi.services.Tiller.ListReleasesRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.ListReleasesResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_RELEASES, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetReleasesStatus retrieves status information for the specified release.
     * </pre>
     */
    public void getReleaseStatus(io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_RELEASE_STATUS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetReleaseContent retrieves the release content (chart + value) for the specified release.
     * </pre>
     */
    public void getReleaseContent(io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_RELEASE_CONTENT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UpdateRelease updates release content.
     * </pre>
     */
    public void updateRelease(io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_RELEASE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * InstallRelease requests installation of a chart as a new release.
     * </pre>
     */
    public void installRelease(io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INSTALL_RELEASE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UninstallRelease requests deletion of a named release.
     * </pre>
     */
    public void uninstallRelease(io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNINSTALL_RELEASE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetVersion returns the current version of the server.
     * </pre>
     */
    public void getVersion(io.winhong.pass.hapi.services.Tiller.GetVersionRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetVersionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_VERSION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RollbackRelease rolls back a release to a previous version.
     * </pre>
     */
    public void rollbackRelease(io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLLBACK_RELEASE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ReleaseHistory retrieves a releasse's history.
     * </pre>
     */
    public void getHistory(io.winhong.pass.hapi.services.Tiller.GetHistoryRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetHistoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HISTORY, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RunReleaseTest executes the tests defined of a named release
     * </pre>
     */
    public void runReleaseTest(io.winhong.pass.hapi.services.Tiller.TestReleaseRequest request,
        io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.TestReleaseResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_RUN_RELEASE_TEST, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * ReleaseService is the service that a helm application uses to mutate,
   * query, and manage releases.
   *		Release: A named installation composed of a chart and
   * 				 config. At any given time a release has one
   *				 chart and one config.
   *		Config:  A config is a YAML file that supplies values
   *				 to the parametrizable templates of a chart.
   *		Chart:   A chart is a helm package that contains
   *				 metadata, a default config, zero or more
   *				 optionally parameterizable templates, and
   *				 zero or more charts (dependencies).
   * </pre>
   */
  public static final class ReleaseServiceBlockingStub extends io.grpc.stub.AbstractStub<ReleaseServiceBlockingStub> {
    private ReleaseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReleaseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReleaseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReleaseServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * ListReleases retrieves release history.
     * TODO: Allow filtering the set of releases by
     * release status. By default, ListAllReleases returns the releases who
     * current status is "Active".
     * </pre>
     */
    public java.util.Iterator<io.winhong.pass.hapi.services.Tiller.ListReleasesResponse> listReleases(
        io.winhong.pass.hapi.services.Tiller.ListReleasesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_RELEASES, getCallOptions(), request);
    }

    /**
     * <pre>
     * GetReleasesStatus retrieves status information for the specified release.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse getReleaseStatus(io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_RELEASE_STATUS, getCallOptions(), request);
    }

    /**
     * <pre>
     * GetReleaseContent retrieves the release content (chart + value) for the specified release.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse getReleaseContent(io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_RELEASE_CONTENT, getCallOptions(), request);
    }

    /**
     * <pre>
     * UpdateRelease updates release content.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse updateRelease(io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_RELEASE, getCallOptions(), request);
    }

    /**
     * <pre>
     * InstallRelease requests installation of a chart as a new release.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse installRelease(io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INSTALL_RELEASE, getCallOptions(), request);
    }

    /**
     * <pre>
     * UninstallRelease requests deletion of a named release.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse uninstallRelease(io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNINSTALL_RELEASE, getCallOptions(), request);
    }

    /**
     * <pre>
     * GetVersion returns the current version of the server.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.GetVersionResponse getVersion(io.winhong.pass.hapi.services.Tiller.GetVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_VERSION, getCallOptions(), request);
    }

    /**
     * <pre>
     * RollbackRelease rolls back a release to a previous version.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse rollbackRelease(io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLLBACK_RELEASE, getCallOptions(), request);
    }

    /**
     * <pre>
     * ReleaseHistory retrieves a releasse's history.
     * </pre>
     */
    public io.winhong.pass.hapi.services.Tiller.GetHistoryResponse getHistory(io.winhong.pass.hapi.services.Tiller.GetHistoryRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HISTORY, getCallOptions(), request);
    }

    /**
     * <pre>
     * RunReleaseTest executes the tests defined of a named release
     * </pre>
     */
    public java.util.Iterator<io.winhong.pass.hapi.services.Tiller.TestReleaseResponse> runReleaseTest(
        io.winhong.pass.hapi.services.Tiller.TestReleaseRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_RUN_RELEASE_TEST, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * ReleaseService is the service that a helm application uses to mutate,
   * query, and manage releases.
   *		Release: A named installation composed of a chart and
   * 				 config. At any given time a release has one
   *				 chart and one config.
   *		Config:  A config is a YAML file that supplies values
   *				 to the parametrizable templates of a chart.
   *		Chart:   A chart is a helm package that contains
   *				 metadata, a default config, zero or more
   *				 optionally parameterizable templates, and
   *				 zero or more charts (dependencies).
   * </pre>
   */
  public static final class ReleaseServiceFutureStub extends io.grpc.stub.AbstractStub<ReleaseServiceFutureStub> {
    private ReleaseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReleaseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReleaseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReleaseServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * GetReleasesStatus retrieves status information for the specified release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse> getReleaseStatus(
        io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_RELEASE_STATUS, getCallOptions()), request);
    }

    /**
     * <pre>
     * GetReleaseContent retrieves the release content (chart + value) for the specified release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse> getReleaseContent(
        io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_RELEASE_CONTENT, getCallOptions()), request);
    }

    /**
     * <pre>
     * UpdateRelease updates release content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse> updateRelease(
        io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_RELEASE, getCallOptions()), request);
    }

    /**
     * <pre>
     * InstallRelease requests installation of a chart as a new release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse> installRelease(
        io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INSTALL_RELEASE, getCallOptions()), request);
    }

    /**
     * <pre>
     * UninstallRelease requests deletion of a named release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse> uninstallRelease(
        io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNINSTALL_RELEASE, getCallOptions()), request);
    }

    /**
     * <pre>
     * GetVersion returns the current version of the server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.GetVersionResponse> getVersion(
        io.winhong.pass.hapi.services.Tiller.GetVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_VERSION, getCallOptions()), request);
    }

    /**
     * <pre>
     * RollbackRelease rolls back a release to a previous version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse> rollbackRelease(
        io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLLBACK_RELEASE, getCallOptions()), request);
    }

    /**
     * <pre>
     * ReleaseHistory retrieves a releasse's history.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.winhong.pass.hapi.services.Tiller.GetHistoryResponse> getHistory(
        io.winhong.pass.hapi.services.Tiller.GetHistoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HISTORY, getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_RELEASES = 0;
  private static final int METHODID_GET_RELEASE_STATUS = 1;
  private static final int METHODID_GET_RELEASE_CONTENT = 2;
  private static final int METHODID_UPDATE_RELEASE = 3;
  private static final int METHODID_INSTALL_RELEASE = 4;
  private static final int METHODID_UNINSTALL_RELEASE = 5;
  private static final int METHODID_GET_VERSION = 6;
  private static final int METHODID_ROLLBACK_RELEASE = 7;
  private static final int METHODID_GET_HISTORY = 8;
  private static final int METHODID_RUN_RELEASE_TEST = 9;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReleaseServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(ReleaseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_RELEASES:
          serviceImpl.listReleases((io.winhong.pass.hapi.services.Tiller.ListReleasesRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.ListReleasesResponse>) responseObserver);
          break;
        case METHODID_GET_RELEASE_STATUS:
          serviceImpl.getReleaseStatus((io.winhong.pass.hapi.services.Tiller.GetReleaseStatusRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetReleaseStatusResponse>) responseObserver);
          break;
        case METHODID_GET_RELEASE_CONTENT:
          serviceImpl.getReleaseContent((io.winhong.pass.hapi.services.Tiller.GetReleaseContentRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetReleaseContentResponse>) responseObserver);
          break;
        case METHODID_UPDATE_RELEASE:
          serviceImpl.updateRelease((io.winhong.pass.hapi.services.Tiller.UpdateReleaseRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.UpdateReleaseResponse>) responseObserver);
          break;
        case METHODID_INSTALL_RELEASE:
          serviceImpl.installRelease((io.winhong.pass.hapi.services.Tiller.InstallReleaseRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.InstallReleaseResponse>) responseObserver);
          break;
        case METHODID_UNINSTALL_RELEASE:
          serviceImpl.uninstallRelease((io.winhong.pass.hapi.services.Tiller.UninstallReleaseRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.UninstallReleaseResponse>) responseObserver);
          break;
        case METHODID_GET_VERSION:
          serviceImpl.getVersion((io.winhong.pass.hapi.services.Tiller.GetVersionRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetVersionResponse>) responseObserver);
          break;
        case METHODID_ROLLBACK_RELEASE:
          serviceImpl.rollbackRelease((io.winhong.pass.hapi.services.Tiller.RollbackReleaseRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.RollbackReleaseResponse>) responseObserver);
          break;
        case METHODID_GET_HISTORY:
          serviceImpl.getHistory((io.winhong.pass.hapi.services.Tiller.GetHistoryRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.GetHistoryResponse>) responseObserver);
          break;
        case METHODID_RUN_RELEASE_TEST:
          serviceImpl.runReleaseTest((io.winhong.pass.hapi.services.Tiller.TestReleaseRequest) request,
              (io.grpc.stub.StreamObserver<io.winhong.pass.hapi.services.Tiller.TestReleaseResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_LIST_RELEASES,
        METHOD_GET_RELEASE_STATUS,
        METHOD_GET_RELEASE_CONTENT,
        METHOD_UPDATE_RELEASE,
        METHOD_INSTALL_RELEASE,
        METHOD_UNINSTALL_RELEASE,
        METHOD_GET_VERSION,
        METHOD_ROLLBACK_RELEASE,
        METHOD_GET_HISTORY,
        METHOD_RUN_RELEASE_TEST);
  }

}
