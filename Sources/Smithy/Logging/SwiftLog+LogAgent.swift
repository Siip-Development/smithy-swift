//
// Copyright Amazon.com Inc. or its affiliates.
// All Rights Reserved.
//
// SPDX-License-Identifier: Apache-2.0
//

public struct SwiftLogger: LogAgent {
    private let label: String

    public init(label: String) {
        self.label = label
    }

    @available(*, deprecated, message: "This API is deprecated. Use init(label:) instead.")
    public init(label: String, logLevel: LogAgentLevel) {
        self.init(label: label)
    }

    public var name: String {
        return label
    }

    public func log(
        level: LogAgentLevel,
        message: @autoclosure () -> String,
        metadata: @autoclosure () -> [String: String]?,
        source: @autoclosure () -> String,
        file: String,
        function: String,
        line: UInt
    ) {
    }
}
