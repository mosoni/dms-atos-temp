/**
 * 
 */
package com.moi.api.handler.internal.result;

import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to generate Document Result
 *
 * Accessibility : Within API handler
 *
 *
 * @author Mohit Soni
 * 
 */
public class GenerateDocumentResult {

	/**
	 * This method is used to genrate Document result for all APIs as result
	 *
	 * @param traceId
	 * @param result
	 * @param resultMessage
	 * @return :
	 */
	public static Page<DocumentResult> generateDocumentResult(long traceId,
			String result, String resultMessage, Object resultFile,
			MOITraceRequest moiTraceRequest) {

		DocumentResult documentResult = new DocumentResult();
		List<DocumentResult> documentResultList = new ArrayList<DocumentResult>();

		documentResult.setTraceId(traceId);
		documentResult.setResult(result);
		documentResult.setResultMessage(resultMessage);
		if (null != resultFile) {
			documentResult.setResultFile(resultFile);
		}
		documentResultList.add(documentResult);

		if (APIConstants.FAILURE.equals(result)) {
			moiTraceRequest.setRequestValid(false);
		} else {
			moiTraceRequest.setRequestValid(true);
		}
		moiTraceRequest.setRequestResult(resultMessage);
		MOITraceRequestLocalServiceUtil.updateMOITraceRequest(moiTraceRequest);

		return Page.of(documentResultList);
	}
}
