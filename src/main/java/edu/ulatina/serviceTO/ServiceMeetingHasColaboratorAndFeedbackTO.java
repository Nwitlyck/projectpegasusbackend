
package edu.ulatina.serviceTO;

import edu.ulatina.interfaces.ICrud;
import edu.ulatina.transfereObjects.MeetingHasColaboratorAndFeedbackTO;
import java.sql.*;
import java.util.*;
/**
 * @author PegasusTeam
 */
public class ServiceMeetingHasColaboratorAndFeedbackTO extends Service implements ICrud<MeetingHasColaboratorAndFeedbackTO>  {

    @Override
    public void insert(MeetingHasColaboratorAndFeedbackTO objectTO) throws Exception {
        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("INSERT INTO meetings_has_colaborators_and_feedback VALUES (?, ?, ?, ?)");
        ps.setInt(1, objectTO.getColaboratorId());
        ps.setInt(2, objectTO.getMeetingId());
        ps.setInt(3, objectTO.getFeedbackId());
        ps.setInt(4, objectTO.getState());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void update(MeetingHasColaboratorAndFeedbackTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("UPDATE meetings_has_colaborators_and_feedback SET state = ? WHERE (colaborator_id = ? AND meetings_id = ? AND feedbacks_id = ?)");
        ps.setInt(1, objectTO.getState());
        ps.setInt(2, objectTO.getColaboratorId());
        ps.setInt(3, objectTO.getMeetingId());
        ps.setInt(4, objectTO.getFeedbackId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public void delete(MeetingHasColaboratorAndFeedbackTO objectTO) throws Exception {

        PreparedStatement ps = null;

        ps = getConnection().prepareStatement("DELETE FROM meetings_has_colaborators_and_feedback WHERE (colaborator_id = ? AND meetings_id = ? AND feedbacks_id = ?)");
        ps.setInt(1, objectTO.getColaboratorId());
        ps.setInt(2, objectTO.getMeetingId());
        ps.setInt(3, objectTO.getFeedbackId());
        ps.executeUpdate();

        close(ps);
        close(conn);
    }

    @Override
    public List<MeetingHasColaboratorAndFeedbackTO> select() throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MeetingHasColaboratorAndFeedbackTO> objectTOList = new ArrayList<MeetingHasColaboratorAndFeedbackTO>();

        ps = getConnection().prepareStatement("SELECT colaborator_id, meetings_id, feedbacks_id, state FROM meetings_has_colaborators_and_feedback WHERE state = 1");
        rs = ps.executeQuery();

        while (rs.next()) {
            int colaborator_id = rs.getInt("colaborator_id");
            int meetings_id = rs.getInt("meetings_id");
            int feedbacks_id = rs.getInt("feedbacks_id");
            int state = rs.getInt("state");

            MeetingHasColaboratorAndFeedbackTO objectTO = new MeetingHasColaboratorAndFeedbackTO(colaborator_id, meetings_id, feedbacks_id, state);

            objectTOList.add(objectTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return objectTOList;
    }

    @Override
    public MeetingHasColaboratorAndFeedbackTO selectByPk(MeetingHasColaboratorAndFeedbackTO objectTO) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        MeetingHasColaboratorAndFeedbackTO meetingHasColaboratorAndFeedbackTO = null;

        ps = getConnection().prepareStatement("SELECT colaborator_id, meetings_id, feedbacks_id, state FROM meetings_has_colaborators_and_feedback WHERE colaborator_id = ? AND meetings_id = ? AND feedbacks_id = ? AND state = 1");
        ps.setInt(1, objectTO.getColaboratorId());
        ps.setInt(2, objectTO.getMeetingId());
        ps.setInt(3, objectTO.getFeedbackId());
        rs = ps.executeQuery();

        if (rs.next()) {
            int colaborator_id = rs.getInt("colaborator_id");
            int meetings_id = rs.getInt("meetings_id");
            int feedbacks_id = rs.getInt("feedbacks_id");
            int state = rs.getInt("state");

            meetingHasColaboratorAndFeedbackTO = new MeetingHasColaboratorAndFeedbackTO(colaborator_id, meetings_id, feedbacks_id, state);

        }

        close(rs);
        close(ps);
        close(conn);

        return meetingHasColaboratorAndFeedbackTO;
    }
    
}
