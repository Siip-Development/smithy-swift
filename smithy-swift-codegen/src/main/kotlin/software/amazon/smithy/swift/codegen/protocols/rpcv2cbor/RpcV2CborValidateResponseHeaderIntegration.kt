package software.amazon.smithy.swift.codegen.protocols.rpcv2cbor

import software.amazon.smithy.model.Model
import software.amazon.smithy.model.shapes.OperationShape
import software.amazon.smithy.model.shapes.ServiceShape
import software.amazon.smithy.protocol.traits.Rpcv2CborTrait
import software.amazon.smithy.swift.codegen.SwiftSettings
import software.amazon.smithy.swift.codegen.SwiftWriter
import software.amazon.smithy.swift.codegen.integration.ProtocolGenerator
import software.amazon.smithy.swift.codegen.integration.SwiftIntegration
import software.amazon.smithy.swift.codegen.integration.middlewares.handlers.MiddlewareShapeUtils
import software.amazon.smithy.swift.codegen.middleware.MiddlewareRenderable
import software.amazon.smithy.swift.codegen.model.shapes
import software.amazon.smithy.swift.codegen.swiftmodules.ClientRuntimeTypes

class CborValidateResponseHeaderIntegration : SwiftIntegration {
    override fun enabledForService(
        model: Model,
        settings: SwiftSettings,
    ): Boolean =
        model
            .shapes<ServiceShape>()
            .any { it.hasTrait(Rpcv2CborTrait::class.java) }
}

class CborValidateResponseHeaderMiddleware : MiddlewareRenderable {
    override val name = "CborValidateResponseHeaderMiddleware"

    override fun renderMiddlewareInit(
        ctx: ProtocolGenerator.GenerationContext,
        writer: SwiftWriter,
        op: OperationShape,
    ) {
        val inputShapeName = MiddlewareShapeUtils.inputSymbol(ctx.symbolProvider, ctx.model, op).name
        val outputShapeName = MiddlewareShapeUtils.outputSymbol(ctx.symbolProvider, ctx.model, op).name
        writer.write(
            "\$N<\$L, \$L>()",
            ClientRuntimeTypes.RpcV2Cbor.CborValidateResponseHeaderMiddleware,
            inputShapeName,
            outputShapeName,
        )
    }
}
