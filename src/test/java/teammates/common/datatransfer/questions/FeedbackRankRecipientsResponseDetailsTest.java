package teammates.common.datatransfer.questions;

import org.junit.Assert;
import teammates.common.datatransfer.attributes.FeedbackResponseAttributes;


import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import teammates.test.BaseTestCase;

/**
 * SUT: {@link FeedbackRankRecipientsResponseDetails}.
 */
public class FeedbackRankRecipientsResponseDetailsTest{
    FeedbackRankRecipientsResponseDetails responseDetails = new FeedbackRankRecipientsResponseDetails();
    @Test
    public void testMaxRankCondition() {
        // Teste para 'if (maxRank <= 0)'

        List<FeedbackResponseAttributes.UpdateOptions> updateOptions = FeedbackRankRecipientsResponseDetails.getUpdateOptionsForRankRecipientQuestions(new ArrayList<>(), -1);
        Assert.assertTrue(updateOptions.isEmpty());

        updateOptions = FeedbackRankRecipientsResponseDetails.getUpdateOptionsForRankRecipientQuestions(new ArrayList<>(), 0);
        Assert.assertTrue(updateOptions.isEmpty());

        updateOptions = FeedbackRankRecipientsResponseDetails.getUpdateOptionsForRankRecipientQuestions(new ArrayList<>(), 1);
        Assert.assertFalse(updateOptions.isEmpty());
    }

    @Test
    public void testDetailsInstanceCondition() {
        // Arrange
        //instances of FeedbackResponseAttributes with FeedbackRankRecipientsResponseDetails as the response detail
        FeedbackResponseAttributes response1 = new FeedbackResponseAttributes();
        response1.setResponseDetails(new FeedbackRankRecipientsResponseDetails());

        FeedbackResponseAttributes response2 = new FeedbackResponseAttributes();
        response2.setResponseDetails(new FeedbackRankRecipientsResponseDetails());

        FeedbackResponseAttributes response3 = new FeedbackResponseAttributes();
        response3.setResponseDetails(new FeedbackRankRecipientsResponseDetails());

        //list containing the instances of FeedbackResponseAttributes
        List<FeedbackResponseAttributes> responses = new ArrayList<>();
        responses.add(response1);
        responses.add(response2);
        responses.add(response3);

        // Act
        //getUpdateOptionsForRankRecipientQuestions method to obtain the update options
        List<FeedbackResponseAttributes.UpdateOptions> updateOptions =
                FeedbackRankRecipientsResponseDetails.getUpdateOptionsForRankRecipientQuestions(responses, 3);

        // check if the list of update options is empty
        Assert.assertTrue(updateOptions.isEmpty());
    }

    @Test
    public void testAnswerMaxRankCondition() {
        // Teste para 'if (answer > maxRank)'

        FeedbackResponseAttributes response1 = new FeedbackResponseAttributes();
        FeedbackRankRecipientsResponseDetails responseDetails1 = new FeedbackRankRecipientsResponseDetails();
        responseDetails1.setAnswer(2);
        response1.setResponseDetails(responseDetails1);

        FeedbackResponseAttributes response2 = new FeedbackResponseAttributes();
        FeedbackRankRecipientsResponseDetails responseDetails2 = new FeedbackRankRecipientsResponseDetails();
        responseDetails2.setAnswer(4);
        response2.setResponseDetails(responseDetails2);

        List<FeedbackResponseAttributes> responses = new ArrayList<>();
        responses.add(response1);
        responses.add(response2);

        List<FeedbackResponseAttributes.UpdateOptions> updateOptions = FeedbackRankRecipientsResponseDetails.getUpdateOptionsForRankRecipientQuestions(responses, 3);

        Assert.assertFalse(updateOptions.isEmpty());
    }
}

