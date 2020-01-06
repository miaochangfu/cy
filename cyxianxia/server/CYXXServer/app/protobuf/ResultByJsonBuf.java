// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ResultByJsonBuf.proto

package protobuf;

public final class ResultByJsonBuf {
  private ResultByJsonBuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface ResultByJsonVoOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // optional string meaasge = 1;
    /**
     * <code>optional string meaasge = 1;</code>
     */
    boolean hasMeaasge();
    /**
     * <code>optional string meaasge = 1;</code>
     */
    java.lang.String getMeaasge();
    /**
     * <code>optional string meaasge = 1;</code>
     */
    com.google.protobuf.ByteString
        getMeaasgeBytes();

    // optional string sign = 2;
    /**
     * <code>optional string sign = 2;</code>
     */
    boolean hasSign();
    /**
     * <code>optional string sign = 2;</code>
     */
    java.lang.String getSign();
    /**
     * <code>optional string sign = 2;</code>
     */
    com.google.protobuf.ByteString
        getSignBytes();
  }
  /**
   * Protobuf type {@code ResultByJsonVo}
   */
  public static final class ResultByJsonVo extends
      com.google.protobuf.GeneratedMessage
      implements ResultByJsonVoOrBuilder {
    // Use ResultByJsonVo.newBuilder() to construct.
    private ResultByJsonVo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private ResultByJsonVo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final ResultByJsonVo defaultInstance;
    public static ResultByJsonVo getDefaultInstance() {
      return defaultInstance;
    }

    public ResultByJsonVo getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private ResultByJsonVo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              meaasge_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              sign_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protobuf.ResultByJsonBuf.internal_static_ResultByJsonVo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protobuf.ResultByJsonBuf.internal_static_ResultByJsonVo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protobuf.ResultByJsonBuf.ResultByJsonVo.class, protobuf.ResultByJsonBuf.ResultByJsonVo.Builder.class);
    }

    public static com.google.protobuf.Parser<ResultByJsonVo> PARSER =
        new com.google.protobuf.AbstractParser<ResultByJsonVo>() {
      public ResultByJsonVo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ResultByJsonVo(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<ResultByJsonVo> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // optional string meaasge = 1;
    public static final int MEAASGE_FIELD_NUMBER = 1;
    private java.lang.Object meaasge_;
    /**
     * <code>optional string meaasge = 1;</code>
     */
    public boolean hasMeaasge() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string meaasge = 1;</code>
     */
    public java.lang.String getMeaasge() {
      java.lang.Object ref = meaasge_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          meaasge_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string meaasge = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMeaasgeBytes() {
      java.lang.Object ref = meaasge_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        meaasge_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string sign = 2;
    public static final int SIGN_FIELD_NUMBER = 2;
    private java.lang.Object sign_;
    /**
     * <code>optional string sign = 2;</code>
     */
    public boolean hasSign() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string sign = 2;</code>
     */
    public java.lang.String getSign() {
      java.lang.Object ref = sign_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          sign_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string sign = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSignBytes() {
      java.lang.Object ref = sign_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sign_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      meaasge_ = "";
      sign_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getMeaasgeBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getSignBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getMeaasgeBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getSignBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobuf.ResultByJsonBuf.ResultByJsonVo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(protobuf.ResultByJsonBuf.ResultByJsonVo prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ResultByJsonVo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements protobuf.ResultByJsonBuf.ResultByJsonVoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return protobuf.ResultByJsonBuf.internal_static_ResultByJsonVo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return protobuf.ResultByJsonBuf.internal_static_ResultByJsonVo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                protobuf.ResultByJsonBuf.ResultByJsonVo.class, protobuf.ResultByJsonBuf.ResultByJsonVo.Builder.class);
      }

      // Construct using protobuf.ResultByJsonBuf.ResultByJsonVo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        meaasge_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        sign_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return protobuf.ResultByJsonBuf.internal_static_ResultByJsonVo_descriptor;
      }

      public protobuf.ResultByJsonBuf.ResultByJsonVo getDefaultInstanceForType() {
        return protobuf.ResultByJsonBuf.ResultByJsonVo.getDefaultInstance();
      }

      public protobuf.ResultByJsonBuf.ResultByJsonVo build() {
        protobuf.ResultByJsonBuf.ResultByJsonVo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public protobuf.ResultByJsonBuf.ResultByJsonVo buildPartial() {
        protobuf.ResultByJsonBuf.ResultByJsonVo result = new protobuf.ResultByJsonBuf.ResultByJsonVo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.meaasge_ = meaasge_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.sign_ = sign_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof protobuf.ResultByJsonBuf.ResultByJsonVo) {
          return mergeFrom((protobuf.ResultByJsonBuf.ResultByJsonVo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(protobuf.ResultByJsonBuf.ResultByJsonVo other) {
        if (other == protobuf.ResultByJsonBuf.ResultByJsonVo.getDefaultInstance()) return this;
        if (other.hasMeaasge()) {
          bitField0_ |= 0x00000001;
          meaasge_ = other.meaasge_;
          onChanged();
        }
        if (other.hasSign()) {
          bitField0_ |= 0x00000002;
          sign_ = other.sign_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        protobuf.ResultByJsonBuf.ResultByJsonVo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (protobuf.ResultByJsonBuf.ResultByJsonVo) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // optional string meaasge = 1;
      private java.lang.Object meaasge_ = "";
      /**
       * <code>optional string meaasge = 1;</code>
       */
      public boolean hasMeaasge() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional string meaasge = 1;</code>
       */
      public java.lang.String getMeaasge() {
        java.lang.Object ref = meaasge_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          meaasge_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string meaasge = 1;</code>
       */
      public com.google.protobuf.ByteString
          getMeaasgeBytes() {
        java.lang.Object ref = meaasge_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          meaasge_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string meaasge = 1;</code>
       */
      public Builder setMeaasge(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        meaasge_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string meaasge = 1;</code>
       */
      public Builder clearMeaasge() {
        bitField0_ = (bitField0_ & ~0x00000001);
        meaasge_ = getDefaultInstance().getMeaasge();
        onChanged();
        return this;
      }
      /**
       * <code>optional string meaasge = 1;</code>
       */
      public Builder setMeaasgeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        meaasge_ = value;
        onChanged();
        return this;
      }

      // optional string sign = 2;
      private java.lang.Object sign_ = "";
      /**
       * <code>optional string sign = 2;</code>
       */
      public boolean hasSign() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string sign = 2;</code>
       */
      public java.lang.String getSign() {
        java.lang.Object ref = sign_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          sign_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string sign = 2;</code>
       */
      public com.google.protobuf.ByteString
          getSignBytes() {
        java.lang.Object ref = sign_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          sign_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string sign = 2;</code>
       */
      public Builder setSign(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        sign_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string sign = 2;</code>
       */
      public Builder clearSign() {
        bitField0_ = (bitField0_ & ~0x00000002);
        sign_ = getDefaultInstance().getSign();
        onChanged();
        return this;
      }
      /**
       * <code>optional string sign = 2;</code>
       */
      public Builder setSignBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        sign_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:ResultByJsonVo)
    }

    static {
      defaultInstance = new ResultByJsonVo(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:ResultByJsonVo)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_ResultByJsonVo_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ResultByJsonVo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025ResultByJsonBuf.proto\"/\n\016ResultByJsonV" +
      "o\022\017\n\007meaasge\030\001 \001(\t\022\014\n\004sign\030\002 \001(\tB\033\n\010prot" +
      "obufB\017ResultByJsonBuf"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_ResultByJsonVo_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_ResultByJsonVo_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ResultByJsonVo_descriptor,
              new java.lang.String[] { "Meaasge", "Sign", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
