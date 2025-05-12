//
// Copyright Amazon.com Inc. or its affiliates.
// All Rights Reserved.
//
// SPDX-License-Identifier: Apache-2.0
//

/// Wrapper for Logger.Level; used by LogAgent and SwiftLogger.
public enum LogAgentLevel: String, Codable, CaseIterable, Sendable {
    case trace
    case debug
    case info
    case notice
    case warn
    case error
    case fatal
}
