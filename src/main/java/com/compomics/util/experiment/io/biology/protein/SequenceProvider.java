package com.compomics.util.experiment.io.biology.protein;

import java.util.HashSet;

/**
 * Interface for a class able to retrieve the sequence of a given protein.
 *
 * @author Marc Vaudel
 */
public interface SequenceProvider {
    
    /**
     * Returns the decoy accessions.
     * 
     * @return the decoy accessions
     */
    public HashSet<String> getDecoyAccessions();
    
    /**
     * Returns the protein sequence for the given accession.
     * 
     * @param proteinAccession the accession of the protein
     * 
     * @return the sequence of the protein
     */
    public String getSequence(String proteinAccession);
    
    /**
     * returns the header for the given protein as a string.
     * 
     * @param proteinAccession the accession of the protein of interest
     * 
     * @return the header as a string
     */
    public String getHeader(String proteinAccession);
    
    /**
     * Returns the subsequence of the sequence of a given protein. Indexes are 0-based like for strings and no exception is thrown if indexes are out of bounds, the substring is trimmed.
     * 
     * @param accession the accession of the protein
     * @param start the start index
     * @param end the end index
     * 
     * @return the subsequence as string
     */
    public String getSubsequence(String accession, int start, int end);

}
